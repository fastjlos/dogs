package com.apriquelme.dogs.domain

import com.apriquelme.dogs.data.repository.RaceRepository

class GetRaceImagesUseCase {

    private val repository = RaceRepository()

    suspend operator fun invoke(race: String) = repository.getImagesByRace(race)

}