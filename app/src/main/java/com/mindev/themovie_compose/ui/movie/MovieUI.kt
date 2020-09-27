package com.mindev.themovie_compose.ui.movie

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.mindev.themovie_compose.ui.entity.MovieViewResult
import com.mindev.themovie_compose.ui.main.MainMovieRouter
import com.mindev.themovie_compose.ui.main.onClickMovieUI
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MovieUI(items: List<MovieViewResult>) {
    val context = ContextAmbient.current
    ScrollableRow(
        modifier = Modifier.align(Alignment.CenterVertically)
            .fillMaxHeight()
            .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 24.dp)
    ) {
        items.map {
            Spacer(Modifier.preferredWidth(4.dp))
            MovieCardUI(it, context)
            Spacer(Modifier.preferredWidth(8.dp))
        }
    }
}

@Composable
fun MovieCardUI(movie: MovieViewResult, context: Context) = Card(
    modifier = Modifier.fillMaxHeight()
        .width(260.dp)
        .clickable(
            onClick = { onClickMovieUI(MainMovieRouter.DetailMovie, context) },
            indication = RippleIndication(color = Color.White)
        ),
    shape = RoundedCornerShape(10.dp),
    backgroundColor = Color.Black,
    border = BorderStroke(width = 1.dp, color = Color.Gray)
) {
    Column(
        modifier = Modifier.padding(4.dp)
            .align(Alignment.CenterVertically)
    ) {
        Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            MovieNetworkImage(movie)
        }
        Spacer(Modifier.preferredHeight(8.dp))
        Text(
            "Average : " + movie.vote_average.toString(),
            style = TextStyle(color = Color.White)
        )
        Spacer(Modifier.preferredHeight(8.dp))
        Text(movie.title, style = TextStyle(color = Color.White))
        Spacer(Modifier.preferredHeight(8.dp))
        Text(movie.overview, style = TextStyle(color = Color.White))
    }
}

@Composable
fun MovieNetworkImage(entity: MovieViewResult) = CoilImage(
    data = "https://image.tmdb.org/t/p/w500/" + entity.poster_path,
    contentScale = ContentScale.Crop,
    modifier = Modifier.width(240.dp)
        .height(240.dp)
        .wrapContentSize(Alignment.Center)
        .aspectRatio(1.0f)
        .clip(CircleShape)
)