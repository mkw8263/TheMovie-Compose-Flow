package com.mindev.themovie_compose.domain.entity

import com.mindev.themovie_compose.ui.entity.KnownForView
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.entity.MoviePersonViewEntity

data class MoviePersonDomainEntity(
    val page: Int,
    val results: List<MoviePersonDomain>,
    val total_pages: Int,
    val total_results: Int
) {
    fun toEntity(): MoviePersonViewEntity {
        return MoviePersonViewEntity(
            page,
            results.map { personData ->
                with(personData) {
                    MoviePersonView(
                        adult, gender, id, known_for.map { knownDomain ->
                            with(knownDomain) {
                                KnownForView(
                                    adult,
                                    backdrop_path,
                                    genre_ids,
                                    id,
                                    media_type,
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
                        },
                        known_for_department, media_type, name, popularity, profile_path
                    )

                }
            }, total_pages, total_results
        )
    }
}

data class MoviePersonDomain(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownForDomain>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)

data class KnownForDomain(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
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