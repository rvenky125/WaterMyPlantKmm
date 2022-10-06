package com.famas.watermyplant.data.repository

import com.famas.watermyplant.model.Plant

interface PlantDataSource {
    suspend fun insertPlant(plant: Plant)
    suspend fun getAllPlants(): List<Plant>
}