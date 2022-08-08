package com.example.radiojavan.android.di

import com.example.radiojavan.android.presentation.search.SearchViewModel
import com.example.radiojavan.android.presentation.track.TrackViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        TrackViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
}

val androidModules = listOf(viewModelModule)