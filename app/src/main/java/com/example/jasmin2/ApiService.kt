package com.example.jasmin2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder().baseUrl("http://myjasminuniqueapp-env.eba-bpf38anp.ap-northeast-2.elasticbeanstalk.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val FitnessListService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("fitnesslist")
    suspend fun getFitnessList(): List<FitnessList>

    @GET("detail/{id}")
    suspend fun getFitnessById(@Path("id") id: Long): FitnessList
}