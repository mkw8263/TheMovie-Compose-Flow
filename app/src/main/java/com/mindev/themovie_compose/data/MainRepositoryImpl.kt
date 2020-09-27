package com.mindev.themovie_compose.data

import com.mindev.themovie_compose.domain.Repository
import com.mindev.themovie_compose.domain.entity.MoviePersonDomainEntity
import com.mindev.themovie_compose.domain.entity.MoviesDomainEntity
import com.mindev.themovie_compose.network.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val service: MovieService) : Repository {
    override suspend fun getMovies(): Flow<MoviesDomainEntity> = flow {
        emit(service.getMovies().toEntity())
    }.flowOn(Dispatchers.IO)

    override suspend fun getPerson(): Flow<MoviePersonDomainEntity> = flow {
        emit(service.getPerson().toEntity())
    }.flowOn(Dispatchers.IO)
}