package com.mindev.themovie_compose.domain

import com.mindev.themovie_compose.data.MainRepositoryImpl
import kotlinx.coroutines.flow.map

class GetMoviePersonUseCase(private val repository: MainRepositoryImpl) {
    suspend operator fun invoke() = repository.getPerson().map { it.toEntity().results }
}