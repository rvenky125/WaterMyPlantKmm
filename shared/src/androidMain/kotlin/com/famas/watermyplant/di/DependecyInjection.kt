package com.famas.watermyplant.di

import com.famas.watermyplant.feature_add_plant.interactors.AddPlantVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual val platformModule = module {
    viewModel {
        AddPlantVM(get())
    }
}