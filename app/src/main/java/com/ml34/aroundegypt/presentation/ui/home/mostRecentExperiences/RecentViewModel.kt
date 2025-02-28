package com.ml34.aroundegypt.presentation.ui.home.mostRecentExperiences

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentFromDbUseCase
import com.ml34.aroundegypt.domain.useCase.recent.GetRecentUseCase
import com.ml34.aroundegypt.domain.useCase.recent.SaveRecentUseCase
import com.ml34.aroundegypt.presentation.bases.BaseViewModel
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

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getRecent() {
        viewModelScope.launch(Dispatchers.IO) {
            val localData = getRecentFromDbUseCase.execute()
            _getRecentLiveData.postValue(localData)
            _isLoading.postValue(true)

            if (isNetworkAvailable(app)) {
                val remoteData = getRecentUseCase.execute().data
                if (remoteData.isNotEmpty()) {
                    saveRecentUseCase.execute(remoteData)
                    _getRecentLiveData.postValue(remoteData)
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