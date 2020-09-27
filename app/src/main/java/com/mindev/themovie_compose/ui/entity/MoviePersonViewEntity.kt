package com.mindev.themovie_compose.ui.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MoviePersonViewEntity(
    val page: Int,
    val results: List<MoviePersonView>,
    val total_pages: Int,
    val total_results: Int
)

@Parcelize
data class MoviePersonView(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownForView>,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
):Parcelable

@Parcelize
data class KnownForView(
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
):Parcelable