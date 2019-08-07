package com.ricardosecchin.pagfilmes

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.ricardosecchin.pagfilmes.endpoints.MovieEndpoint
import com.ricardosecchin.pagfilmes.services.ApiResponse
import com.ricardosecchin.pagfilmes.services.MovieService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val movieService = MovieService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        getMovies(this)
    }

    fun getMovies(context: Context) {
        val callback = movieService.retrofit.create(MovieEndpoint::class.java).getMovies()

        callback.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    recyclerView.adapter = MoviesAdapter(context, response.body()!!.results)
                }
            }

        })
    }

}