package com.mindev.themovie_compose.ui.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieViewEntity(
    val page: Int,
    val results: List<MovieViewResult>,
    val total_pages: Int,
    val total_results: Int
) : Parcelable

@Parcelize
data class MovieViewResult(
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
) : Parcelable