package com.dev.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {
    fun create() : ServiceAPI {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://de-coding-test.s3.amazonaws.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ServiceAPI::class.java)
    }
}