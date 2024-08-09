package com.example.lokal_demo.services

import com.example.lokal_demo.model.JobsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit
    .Builder()
    .baseUrl("https://testapi.getlokalapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val jobServices = retrofit.create(ApiServices::class.java)


interface ApiServices {
    @GET("common/jobs?page=1")
    suspend fun getJobs() :JobsResponse
}

//https://testapi.getlokalapp.com/