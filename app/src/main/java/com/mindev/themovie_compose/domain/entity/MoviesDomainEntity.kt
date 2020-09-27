package com.mindev.themovie_compose.domain.entity

import com.mindev.themovie_compose.ui.entity.MovieViewEntity
import com.mindev.themovie_compose.ui.entity.MovieViewResult


class MoviesDomainEntity(
    private val page: Int,
    private val results: List<DomainResult>,
    private val total_pages: Int,
    private val total_results: Int
) {
    fun toEntity(): MovieViewEntity {
        return MovieViewEntity(
            page,
            results.map {
                MovieViewResult(
                    it.adult,
                    it.backdrop_path,
                    it.genre_ids,
                    it.id,
                    it.original_language,
                    it.original_title,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.release_date,
                    it.title,
                    it.video,
                    it.vote_average,
                    it.vote_count
                )
            },
            total_pages,
            total_results
        )
    }
}

data class DomainResult(
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