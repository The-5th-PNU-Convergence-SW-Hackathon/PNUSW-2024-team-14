package com.example.jasmin2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class FitnessList(
    val id: Long,
    val name: String,
    val weekdaytime: String,
    val holidaytime: String,
    val phone: String,
    val address: String,
    val rating: Double,
    val monthprice: Long,
    val threeprice: Long,
    val sixprice: Long,
    val imgtegst: String,
    val imgtegnd: String,
    val imgtegrd: String
)

data class FitnessListResponse(val fitnesslist: List<FitnessList>)