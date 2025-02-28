package com.ml34.aroundegypt.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.SaveRecommendedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendedViewModel @Inject constructor(
    val app: Application,
    private val getRecommendedUseCase: GetRecommendedUseCase,
    private val getRecommendedFromDbUseCase: GetRecommendedFromDbUseCase,
    private val saveRecommendedUseCase: SaveRecommendedUseCase
) : BaseViewModel() {
    private val _getRecommendedLiveData = MutableLiveData<List<ExperienceModel>>()
    val getRecommendedLiveData: LiveData<List<ExperienceModel>> get() = _getRecommendedLiveData

    fun getRecommended() {
        viewModelScope.launch(Dispatchers.IO) {
            val localData = getRecommendedFromDbUseCase.execute()
            _getRecommendedLiveData.postValue(localData)

            if (isNetworkAvailable(app)) {
                val remoteData = getRecommendedUseCase.execute().data
                if (remoteData.isNotEmpty()) {
                    saveRecommendedUseCase.execute()
                    _getRecommendedLiveData.postValue(remoteData)
                }
            }
        }
    }

}