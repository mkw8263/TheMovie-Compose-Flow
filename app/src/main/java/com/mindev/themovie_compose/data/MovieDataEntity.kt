package com.mindev.themovie_compose.data

import com.mindev.themovie_compose.domain.entity.DomainResult
import com.mindev.themovie_compose.domain.entity.MoviesDomainEntity

data class DataMovieEntity(
    val page: Int,
    val results: List<DataMovie>,
    val total_pages: Int,
    val total_results: Int
) {
    fun toEntity(): MoviesDomainEntity {
        return MoviesDomainEntity(
            page, results.map {
                with(it) {
                    DomainResult(
                        adult,
                        backdrop_path,
                        genre_ids,
                        id,
                        original_language,
                        original_title,
                        overview,
                        popularity,
                        poster_path,
                        release_date,
                        title,
                        video,
                        vote_average,
                        vote_count
                    )
                }
            }, total_pages, total_results
        )
    }
}

data class DataMovie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)