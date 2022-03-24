package com.apriquelme.dogs.data.models

import com.google.gson.annotations.SerializedName

data class RaceImageDataModel(
    @SerializedName("status") val status : String,
    @SerializedName("message") val message : List<String>,
)