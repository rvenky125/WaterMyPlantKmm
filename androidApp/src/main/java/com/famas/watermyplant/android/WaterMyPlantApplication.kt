package com.famas.watermyplant.android

import android.app.Application
import com.famas.watermyplant.di.allCommonModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WaterMyPlantApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WaterMyPlantApplication)
            androidLogger()
            modules(allCommonModules)
        }
    }
}