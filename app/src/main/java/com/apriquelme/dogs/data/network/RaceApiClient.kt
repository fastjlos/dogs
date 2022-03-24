package com.apriquelme.dogs.data.network

import com.apriquelme.dogs.data.models.RaceImageDataModel
import com.apriquelme.dogs.data.models.RacesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RaceApiClient {

    @GET("breeds/list/all")
    suspend fun getRacesList() : Response<RacesResponse>


    @GET("breed/{race}/images")
    suspend fun getImagesByRace(@Path("race") race: String): Response<RaceImageDataModel>

}