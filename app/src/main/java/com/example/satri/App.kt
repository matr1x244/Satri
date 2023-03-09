package com.example.satri

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.satri.di.koin.loginKoinModule
import com.example.satri.di.koin.mainModuleKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(mainModuleKoin,loginKoinModule)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var appInstance: Context
    }

}