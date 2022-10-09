package com.famas.watermyplant.di

import com.famas.watermyplant.feature_add_plant.data.repository.PlantRepositoryImpl
import com.famas.watermyplant.feature_add_plant.domain.repository.PlantRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val addPlantModule = module {

}

val mainModule = module {
    single<PlantRepository> {
        PlantRepositoryImpl()
    }
}

expect val platformModule: Module