package com.apriquelme.dogs.data.repository

import com.apriquelme.dogs.data.models.RaceDataModel
import com.apriquelme.dogs.data.network.RaceService


class RaceRepository {

    private val api = RaceService()

    suspend fun getRacesList(): MutableList<RaceDataModel> {
        return api.getRacesList()
    }

    suspend fun getImagesByRace(race: String): List<String> {
        return api.getImagesByRace(race)
    }


}