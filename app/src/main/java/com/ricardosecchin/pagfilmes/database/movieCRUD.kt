package com.ricardosecchin.pagfilmes.database

import com.ricardosecchin.pagfilmes.model.Movie
import io.realm.Realm
import io.realm.RealmConfiguration

class movieCRUD {
    //---------------------------------------------CREATE------------------------------------------------------------

    fun addFavoritosDataBase(movie: Movie): Boolean {
        val config = RealmConfiguration.Builder()
            .name("filmesFavoritos.realm")
            .build()
        val realm = Realm.getInstance(config)
        val filme = realm.where(MovieDB::class.java).equalTo("id", movie.id).findFirst()

        if (filme == null) {
            realm.beginTransaction()
            val movieDB = realm.createObject(MovieDB::class.java, movie.id)
            movieDB.title = movie.title
            movieDB.overview = movie.overview
            movieDB.poster_path = movie.poster_path
            realm.commitTransaction()
            return true
        }
        else{
            if(filme.id != movie.id){
                realm.beginTransaction()
                val movieDB = realm.createObject(MovieDB::class.java, movie.id)
                movieDB.title = movie.title
                movieDB.overview = movie.overview
                movieDB.poster_path = movie.poster_path
                realm.commitTransaction()
                return true
            }
        }
        return false
    }
}