package com.apriquelme.dogs.data.models

import com.google.gson.annotations.SerializedName

data class RacesResponse(
    @SerializedName("status") val status : String,
    @SerializedName("message") val message : Map<String, Array<String>>,
)