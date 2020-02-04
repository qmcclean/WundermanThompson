package com.dev.myapplication.api

import com.dev.myapplication.model.BooksResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {
    @GET("/books.json")
    fun getBooks() : Call<List<BooksResponse>>
}