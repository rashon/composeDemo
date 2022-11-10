package com.example.composedemo.di

import com.example.composedemo.ui.fragment.breeddetails.BreedDetailsVM
import com.example.composedemo.ui.fragment.breedlist.BreedListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BreedListVM(get()) }
    viewModel { BreedDetailsVM() }
}