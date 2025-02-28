package com.ml34.aroundegypt.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recent.SaveRecentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentViewModel @Inject constructor(
    val app: Application,
    private val getRecentUseCase: GetRecentUseCase,
    private val getRecentFromDbUseCase: GetRecentFromDbUseCase,
    private val saveRecentUseCase: SaveRecentUseCase
) : BaseViewModel() {
    private val _getRecentLiveData = MutableLiveData<List<ExperienceModel>>()
    val getRecentLiveData: LiveData<List<ExperienceModel>> get() = _getRecentLiveData

    fun getRecent() {
        viewModelScope.launch(Dispatchers.IO) {
            val localData = getRecentFromDbUseCase.execute()
            _getRecentLiveData.postValue(localData)

            if (isNetworkAvailable(app)) {
                val remoteData = getRecentUseCase.execute().data
                if (remoteData.isNotEmpty()) {
                    saveRecentUseCase.execute(remoteData)
                    _getRecentLiveData.postValue(remoteData)
                }
            }
        }
    }

}