package com.mindev.themovie_compose

import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations

class InjectMocks{
    companion object{
        fun create(testClass:Any) = TestRule { base, _ ->
            MockitoAnnotations.initMocks(testClass)
            base
        }
    }
}