package com.mindev.themovie_compose.ui.main

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.entity.MovieViewResult
import com.mindev.themovie_compose.ui.movie.MovieUI
import com.mindev.themovie_compose.ui.movie.PersonUI
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun movieMain(viewModel: MainViewModel) {
    val movieItems: List<MovieViewResult> by viewModel.movieList.observeAsState(listOf())
    val personItems: List<MoviePersonView> by viewModel.personList.observeAsState(listOf())
    val isMovieProgress: Boolean by viewModel.isMovieProgress.observeAsState(false)
    val isMoviePersonProgress: Boolean by viewModel.isMoviePersonProgress.observeAsState(false)

    ConstraintLayout {
        Scaffold(backgroundColor = Color.Black) {
            Column {
                Box(modifier = Modifier.weight(0.1f), children = {
                    Text(
                        text = "MinDev - The Movie Compose Demo",
                        modifier = Modifier.padding(start = 8.dp, top = 36.dp, bottom = 16.dp),
                        style = TextStyle(color = Color.White, fontSize = TextUnit.Sp(18))
                    )
                })
                Box(modifier = Modifier.weight(0.7f), children = { MovieUI(movieItems) })
                Box(
                    modifier = Modifier.weight(0.2f),
                    children = { PersonUI(personItems) })
            }
        }
    }
}