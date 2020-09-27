package com.mindev.themovie_compose

import net.bytebuddy.matcher.ElementMatchers.`is`
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataMovieRepository {


    @Test
    fun test(){
        assertThat(true, CoreMatchers.`is`(true))
    }
}