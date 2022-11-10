package com.example.composedemo

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedemo.di.apiModule
import com.example.composedemo.di.repositoryModule
import com.example.composedemo.di.viewModelModule
import com.example.composedemo.ui.theme.ComposeDemoTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainActivity)
            // Load modules
            modules(viewModelModule, repositoryModule, apiModule)
        }
        setContent {
            ComposeDemoTheme {
                ComposeDemoNavGraph()
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        ComposeDemoNavGraph()
    }
}