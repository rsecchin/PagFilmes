package com.ricardosecchin.pagfilmes.endpoints


import com.ricardosecchin.pagfilmes.services.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieEndpoint {

    enum class SortBy private constructor(internal var value: String) {
        RELEASE_DATE_ASCENDING("release_date.asc"),
        RELEASE_DATE_DESCENDING("release_date.desc");


        override fun toString(): String {
            return this.value
        }
    }


    @GET("3/movie/upcoming?sort_by=release_date.desc&api_key=1f54bd990f1cdfb230adb312546d765d&language=pt-BR&page=1")
    fun getMovies(): Call<ApiResponse>
}