package com.ricardosecchin.pagfilmes.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieService {

    private val URL = "https://api.themoviedb.org/"


    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}