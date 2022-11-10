package com.example.composedemo.di

import com.example.composedemo.domain.repository.BreedsRepository
import com.example.composedemo.domain.repository.BreedsRepositoryImpl
import com.example.composedemo.domain.service.BreedListService
import org.koin.dsl.module

val repositoryModule = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get(), get()) }
    single { BreedListService() }
}