package com.mindev.themovie_compose.ui.main

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.align
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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

    Scaffold(backgroundColor = Color.Black) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier.weight(0.1f)
                        .padding(start = 8.dp, top = 36.dp, bottom = 16.dp), children = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "MinDev - The Movie Compose Demo",
                                style = TextStyle(color = Color.White, fontSize = TextUnit.Sp(18))
                            )
                            Switch(
                                checked = true,
                                onCheckedChange = {},
                                color = Color.White
                            )
                        }
                    },
                    gravity = Alignment.Center
                )
                Box(
                    gravity = Alignment.Center,
                    modifier = Modifier.weight(0.7f),
                    children = { MovieUI(movieItems, isMovieProgress) })
                Box(
                    modifier = Modifier.weight(0.2f)
                        .align(alignment = Alignment.CenterHorizontally),
                    children = { PersonUI(personItems, isMoviePersonProgress) })
            }
        }
    }
}