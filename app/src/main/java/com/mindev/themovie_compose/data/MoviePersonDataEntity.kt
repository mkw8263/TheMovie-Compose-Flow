package com.mindev.themovie_compose.data

import com.mindev.themovie_compose.domain.entity.KnownForDomain
import com.mindev.themovie_compose.domain.entity.MoviePersonDomain
import com.mindev.themovie_compose.domain.entity.MoviePersonDomainEntity

data class MoviePersonDataEntity(
    val page: Int,
    val results: List<MoviePersonData>,
    val total_pages: Int,
    val total_results: Int
) {
    fun toEntity(): MoviePersonDomainEntity {
        return MoviePersonDomainEntity(
            page,
            results.map { personData ->
                with(personData) {
                    MoviePersonDomain(
                        adult, gender, id, known_for.map { knownDomain ->
                            with(knownDomain) {
                                KnownForDomain(
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

data class MoviePersonData(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownForData>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)

data class KnownForData(
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