package com.ricardosecchin.pagfilmes

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.ricardosecchin.pagfilmes.database.movieCRUD
import com.ricardosecchin.pagfilmes.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        //actionbar
        val actionbar = supportActionBar

        val movie_title :String = intent.getStringExtra("title")
        val movie_overview :String = intent.getStringExtra("overview")
        val movie_poster_path :String = intent.getStringExtra("poster_path")
        val movie_date :String = intent.getStringExtra("release_date")

        actionbar!!.title = movie_title
        actionbar.setDisplayHomeAsUpEnabled(true)

        release_date.text = movie_date
        txt_overview.text = movie_overview
        Picasso.get().load("https://image.tmdb.org/t/p/w185$movie_poster_path").into(image_poster)

        lateinit var filme: Movie
        lateinit var container: View

        fav.setOnClickListener{
            if(movieCRUD().addFavoritosDataBase(filme))
                Snackbar.make(container, "Filme adicionado aos favoritos!!", Snackbar.LENGTH_SHORT).show()
            else
                Snackbar.make(container, "Este filme já foi adicionado aos favoritos!!!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }
