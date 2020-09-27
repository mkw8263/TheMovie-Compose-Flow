package com.mindev.themovie_compose.network

import com.mindev.themovie_compose.data.DataMovieEntity
import com.mindev.themovie_compose.data.MoviePersonDataEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String = "api key"): DataMovieEntity

    @GET("/3/trending/person/week")
    suspend fun getPerson(@Query("api_key") apiKey: String = "api key"): MoviePersonDataEntity
}