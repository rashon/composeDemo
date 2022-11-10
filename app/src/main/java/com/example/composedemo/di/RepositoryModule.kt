package com.example.composedemo.di

import com.example.composedemo.api.ApiService
import com.example.composedemo.domain.repository.BreedsRepository
import com.example.composedemo.domain.repository.BreedsRepositoryImpl
import com.example.composedemo.ui.fragment.breeddetails.BreedDetailsVM
import com.example.composedemo.ui.fragment.breedlist.BreedListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get()) }
}