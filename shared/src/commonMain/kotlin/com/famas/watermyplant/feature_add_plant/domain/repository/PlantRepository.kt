package com.famas.watermyplant.feature_add_plant.domain.repository

import com.famas.watermyplant.model.Plant

interface PlantRepository {
    suspend fun insertPlant(plant: Plant)
    suspend fun getAllPlants(): List<Plant>
}