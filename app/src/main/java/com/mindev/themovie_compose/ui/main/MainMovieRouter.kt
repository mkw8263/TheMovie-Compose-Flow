package com.mindev.themovie_compose.ui.main

import android.content.Context
import android.content.Intent
import com.mindev.themovie_compose.ui.DetailMainActivity
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.profile.DetailPersonActivity
import com.mindev.themovie_compose.ui.profile.DetailPersonActivity.Companion.EXTRA_PERSON


sealed class MainMovieRouter {
    object DetailMovie : MainMovieRouter()
    data class DetailProfile(val data: MoviePersonView) : MainMovieRouter()
}

fun onClickMovieUI(router: MainMovieRouter, context: Context) {
    val intent = when (router) {
        is MainMovieRouter.DetailMovie -> Intent(context, DetailMainActivity::class.java)
        is MainMovieRouter.DetailProfile -> Intent(context, DetailPersonActivity::class.java).apply {
            putExtra(EXTRA_PERSON,router.data)
        }
    }

    context.startActivity(intent)
}