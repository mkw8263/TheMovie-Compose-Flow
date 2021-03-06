package com.mindev.themovie_compose.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mindev.themovie_compose.domain.GetMoviePersonUseCase
import com.mindev.themovie_compose.domain.GetMovieUseCase
import com.mindev.themovie_compose.ui.entity.MoviePersonView
import com.mindev.themovie_compose.ui.entity.MovieViewResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getMoviePersonUseCase: GetMoviePersonUseCase
) : ViewModel() {

    private var _movieList: MutableLiveData<List<MovieViewResult>> = MutableLiveData()
    val movieList: LiveData<List<MovieViewResult>> get() = _movieList

    private var _personList: MutableLiveData<List<MoviePersonView>> = MutableLiveData()
    val personList: LiveData<List<MoviePersonView>> get() = _personList

    private val _isMovieProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val isMovieProgress: LiveData<Boolean> get() = _isMovieProgress

    private val _isMoviePersonProgress: MutableLiveData<Boolean> = MutableLiveData(false)
    val isMoviePersonProgress: LiveData<Boolean> get() = _isMoviePersonProgress

    init {
        getMovies()
        getPerson()
    }

    private fun getMovies() = viewModelScope.launch {
        getMovieUseCase.invoke()
            .onStart { _isMovieProgress.postValue(true) }
            .onCompletion { _isMovieProgress.postValue(false) }
            .catch { _isMovieProgress.postValue(false) }
            .collect { _movieList.postValue(it) }
    }

    private fun getPerson() = viewModelScope.launch {
        getMoviePersonUseCase.invoke()
            .onStart { _isMoviePersonProgress.postValue(true)}
            .onCompletion { _isMoviePersonProgress.postValue(false) }
            .catch { _isMoviePersonProgress.postValue(false) }
            .collect { _personList.postValue(it)}
    }
}