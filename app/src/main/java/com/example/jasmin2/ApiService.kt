package com.example.jasmin2

import com.example.jasmin2.fitness.FitnessList
import com.example.jasmin2.login.LoginResponse
import com.example.jasmin2.login.RegisterResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("displayName") displayName: String
    ): Response<RegisterResponse>
}