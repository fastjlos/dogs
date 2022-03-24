package com.apriquelme.dogs.domain

import com.apriquelme.dogs.data.repository.RaceRepository

class GetRacesUseCase {

    private val repository = RaceRepository()

    suspend operator fun invoke() = repository.getRacesList()

}