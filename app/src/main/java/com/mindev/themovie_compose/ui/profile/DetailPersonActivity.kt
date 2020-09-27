package com.mindev.themovie_compose.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.setContent
import com.mindev.themovie_compose.R
import com.mindev.themovie_compose.ui.entity.MoviePersonView

class DetailPersonActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getParcelableExtra<MoviePersonView>(EXTRA_PERSON)?.let {
            setContent {
                MaterialTheme {
                    DetailPersonUI(it)
                }
            }
        } ?: run {
            finish()
        }
    }
}