package com.ricardosecchin.pagfilmes

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricardosecchin.pagfilmes.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_card.view.*

class MoviesAdapter(val context: Context, val movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolderClass {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_card, parent, false)
        return MyViewHolderClass(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolderClass, index: Int) {
        val movie = movies[index]
        holder.setData(movie, context)
    }


    class MyViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(movie: Movie, context: Context) {
            itemView.title.text = movie.title
            itemView.release_date.text = movie.release_date
            Picasso.get().load("https://image.tmdb.org/t/p/w185" + movie.poster_path).into(itemView.image_poster)
            itemView.setOnClickListener {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("title", movie.title)
                intent.putExtra("release_date", movie.release_date)
                intent.putExtra("overview", movie.overview)
                intent.putExtra("poster_path", movie.poster_path)
                startActivity(context, intent, null)
            }
        }

    }

}