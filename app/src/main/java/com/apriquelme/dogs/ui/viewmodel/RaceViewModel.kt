package com.apriquelme.dogs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apriquelme.dogs.data.models.RaceDataModel
import com.apriquelme.dogs.domain.GetRaceImagesUseCase
import com.apriquelme.dogs.domain.GetRacesUseCase
import kotlinx.coroutines.launch

class RaceViewModel: ViewModel() {

    val raceModel = MutableLiveData<MutableList<RaceDataModel>>()
    val raceImageModel = MutableLiveData<List<String>>()
    val isLoading = MutableLiveData<Boolean>()

    var getRacesUseCase = GetRacesUseCase()
    var getRaceImagesUseCase = GetRaceImagesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRacesUseCase()

            if(!result.isNullOrEmpty()){
                raceModel.postValue(result)
            }
            isLoading.postValue(false)
        }
    }

    fun getImagesByRace(race: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val images = getRaceImagesUseCase(race)

            if(images != null){
                raceImageModel.postValue(images)
            }
            isLoading.postValue(false)
        }
    }

}