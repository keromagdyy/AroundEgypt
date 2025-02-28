package com.ml34.aroundegypt.presentation.ui.home.recommendedExperiences

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.GetRecommendedUseCase
import com.ml34.aroundegypt.domain.useCase.recommended.SaveRecommendedUseCase
import com.ml34.aroundegypt.presentation.bases.BaseViewModel
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

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getRecommended() {
        viewModelScope.launch(Dispatchers.IO) {
            val localData = getRecommendedFromDbUseCase.execute()
            _getRecommendedLiveData.postValue(localData)
            _isLoading.postValue(true)

            if (isNetworkAvailable(app)) {
                val remoteData = getRecommendedUseCase.execute().data
                if (remoteData.isNotEmpty()) {
                    saveRecommendedUseCase.execute()
                    _getRecommendedLiveData.postValue(remoteData)
                    _isLoading.postValue(false)
                } else {
                    _isLoading.postValue(false)
                }
            } else {
                _isLoading.postValue(false)
            }
        }
    }

}