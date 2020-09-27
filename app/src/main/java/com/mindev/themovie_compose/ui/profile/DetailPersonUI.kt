package com.mindev.themovie_compose.ui.profile

import androidx.compose.foundation.Box
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailProfileImage(path: String) = CoilImage(
    data = "https://image.tmdb.org/t/p/w200$path",
    contentScale = ContentScale.Crop,
    modifier = Modifier.width(240.dp)
        .height(240.dp)
        .wrapContentSize(Alignment.Center)
        .aspectRatio(1.0f)
        .clip(CircleShape)
)

@Composable
fun DetailPersonUI(data: MoviePersonView) {
    Scaffold(backgroundColor = Color.Black) {
        Column {
            Box(modifier = Modifier.weight(0.35f).align(alignment = Alignment.CenterHorizontally)) {
                Spacer(modifier = Modifier.height(16.dp))
                DetailProfileImage(data.profile_path)
            }
            Box(modifier = Modifier.weight(0.65f)) {
                Spacer(modifier = Modifier.height(24.dp))
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
                        data = "https://image.tmdb.org/t/p/w500" + it.poster_path,
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