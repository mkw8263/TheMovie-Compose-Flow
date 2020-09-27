package com.mindev.themovie_compose.domain

import com.mindev.themovie_compose.data.MainRepositoryImpl
import kotlinx.coroutines.flow.map

class GetMovieUseCase(private val repository: MainRepositoryImpl) {
    suspend operator fun invoke() = repository.getMovies().map { it.toEntity().results }
}