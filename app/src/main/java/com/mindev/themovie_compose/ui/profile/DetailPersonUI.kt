package com.mindev.themovie_compose.ui.profile

import androidx.compose.foundation.Box
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.movie.ProfileImage
import jp.wasabeef.composable.coil.CoilImage

@Composable
fun DetailPersonUI(data: MoviePersonView) {
    Scaffold(modifier = Modifier.padding(top = 36.dp), backgroundColor = Color.Black) {
        Column {
            Box(modifier = Modifier.weight(0.2f)) {
                ProfileImage(data)
            }
            Divider()
            Box(modifier = Modifier.weight(0.8f)) {
                MoviePersonBody(data)
            }
        }
    }
}

@Composable
fun MoviePersonBody(data: MoviePersonView) =
    Column(modifier = Modifier.padding(start = 24.dp, top = 36.dp, end = 24.dp, bottom = 12.dp)) {
        Text(
            data.name,
            style = TextStyle(color = Color.White, fontSize = TextUnit.Companion.Sp(20))
        )
        Spacer(modifier = Modifier.height(24.dp))
        ScrollableRow {
            data.known_for.map {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CoilImage(
                        model = "https://image.tmdb.org/t/p/w500" + it.poster_path,
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                            .width(120.dp)
                    )
                    Text(
                        it.title,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = TextUnit.Companion.Sp(10)
                        )
                    )
                }
                Spacer(Modifier.preferredWidth(4.dp))
            }
        }
    }