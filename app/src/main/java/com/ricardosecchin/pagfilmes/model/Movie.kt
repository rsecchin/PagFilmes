package com.ricardosecchin.pagfilmes.model

data class Movie (
    var id: Int,
    var title: String,
    var poster_path: String,
    var release_date: String,
    var overview: String)