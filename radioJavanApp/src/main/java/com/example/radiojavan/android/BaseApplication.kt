package com.example.radiojavan.android

import android.app.Application
import com.example.radiojavan.android.di.androidModules
import com.example.radiojavan.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin() {
            androidContext(this@BaseApplication)
            modules(androidModules)
        }
    }
}