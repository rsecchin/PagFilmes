package com.ricardosecchin.pagfilmes.services

import com.ricardosecchin.pagfilmes.model.Movie

class ApiResponse (
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<Movie>)