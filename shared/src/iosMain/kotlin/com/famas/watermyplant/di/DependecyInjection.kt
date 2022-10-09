package com.famas.watermyplant.di

import com.famas.watermyplant.feature_add_plant.interactors.AddPlantVM
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

actual val platformModule = module {
    factory {
        AddPlantVM(get())
    }
}

object viewModels: KoinComponent {
    fun getAddPlantViewModel() = get<AddPlantVM>()
}