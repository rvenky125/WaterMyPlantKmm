package com.famas.watermyplant.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(mainModule, )
    }
}

val allCommonModules = listOf(
    mainModule,
    addPlantModule,
    platformModule
)