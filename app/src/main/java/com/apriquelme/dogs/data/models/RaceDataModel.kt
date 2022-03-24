package com.apriquelme.dogs.data.models

data class RaceDataModel(
    val name : String = "",
    val subRaceList : MutableList<String> = arrayListOf()
)