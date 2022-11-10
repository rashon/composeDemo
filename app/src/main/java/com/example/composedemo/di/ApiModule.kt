package com.example.composedemo.di

import com.example.composedemo.api.ApiService
import org.koin.dsl.module

val apiModule = module {
    single { ApiService.getInstance() }
}