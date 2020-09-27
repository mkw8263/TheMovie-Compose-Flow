package com.mindev.themovie_compose.di

import com.mindev.themovie_compose.data.MainRepositoryImpl
import com.mindev.themovie_compose.domain.GetMoviePersonUseCase
import com.mindev.themovie_compose.domain.GetMovieUseCase
import com.mindev.themovie_compose.domain.Repository
import com.mindev.themovie_compose.network.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(service: MovieService): Repository =
        MainRepositoryImpl(service)

    @Provides
    @ActivityRetainedScoped
    fun provideGetMovieUseCase(repository: MainRepositoryImpl) = GetMovieUseCase(repository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetMoviePersonUseCase(repository: MainRepositoryImpl) = GetMoviePersonUseCase(repository)
}