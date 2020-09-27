package com.mindev.themovie_compose.domain

import com.mindev.themovie_compose.domain.entity.MoviePersonDomainEntity
import com.mindev.themovie_compose.domain.entity.MoviesDomainEntity
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovies(): Flow<MoviesDomainEntity>
    suspend fun getPerson(): Flow<MoviePersonDomainEntity>
}