package com.apriquelme.dogs.data.network

import com.apriquelme.dogs.data.models.RaceDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RaceService {

    private val baseUrl = "https://dog.ceo/api/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    suspend fun getRacesList(): MutableList<RaceDataModel> {
        return withContext(Dispatchers.IO) {

            val response = retrofit.create(RaceApiClient::class.java).getRacesList()
            //response.body()?.message ?: HashMap()
            val raceList = mutableListOf<RaceDataModel>()

            if (response.body() != null) {
                if (response.body()!!.message != null) {
                    response.body()!!.message.forEach { race ->
                        val subRaceList = mutableListOf<String>()
                        race.value.forEach { subRace ->
                            subRaceList.add(subRace)
                        }
                        raceList.add(RaceDataModel(race.key, subRaceList))
                    }
                }
            }

            raceList
        }
    }

    suspend fun getImagesByRace(race: String): List<String> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RaceApiClient::class.java).getImagesByRace(race)
            response.body()?.message ?: emptyList()
        }
    }

}