package com.mindev.themovie_compose.ui.movie

import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.main.MainMovieRouter
import com.mindev.themovie_compose.ui.main.MainViewModel
import com.mindev.themovie_compose.ui.main.onClickMovieUI
import jp.wasabeef.composable.coil.CoilImage
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun PersonUI(personItems: List<MoviePersonView>, viewModel: MainViewModel) {
    val context = ContextAmbient.current
    ScrollableRow(modifier = Modifier.align(Alignment.Bottom).fillMaxWidth()) {
        personItems.map {
            Column(
                modifier = Modifier.clickable(
                    onClick = {
                        onClickMovieUI(
                            MainMovieRouter.DetailProfile(it),
                            context
                        )
                    },
                    indication = RippleIndication(color = Color.White)
                ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage(it)
                Text(
                    overflow = TextOverflow.Clip,
                    text = it.name,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = TextUnit.Sp(8)
                    )
                )
            }
            Spacer(Modifier.preferredWidth(4.dp))
        }
    }
}

@Composable
fun ProfileImage(entity: MoviePersonView) = CoilImage(
    model = "https://image.tmdb.org/t/p/w200" + entity.profile_path,
    modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
)