package com.example.composedemo

import android.app.Application
import com.example.composedemo.di.apiModule
import com.example.composedemo.di.repositoryModule
import com.example.composedemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(viewModelModule, repositoryModule, apiModule)
        }
    }
}