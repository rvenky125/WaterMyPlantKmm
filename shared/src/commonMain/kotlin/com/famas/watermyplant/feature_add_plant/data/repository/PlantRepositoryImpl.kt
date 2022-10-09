package com.famas.watermyplant.feature_add_plant.data.repository

import com.famas.watermyplant.db.objects.add_plant.PlantObject
import com.famas.watermyplant.db.realm
import com.famas.watermyplant.feature_add_plant.domain.mappers.toPlant
import com.famas.watermyplant.feature_add_plant.domain.mappers.toPlantObject
import com.famas.watermyplant.feature_add_plant.domain.repository.PlantRepository
import com.famas.watermyplant.model.Plant
import io.realm.kotlin.ext.query

class PlantRepositoryImpl: PlantRepository {
    override suspend fun insertPlant(plant: Plant) {
        realm.write {
            copyToRealm(plant.toPlantObject())
        }
    }

    override suspend fun getAllPlants(): List<Plant> {
        return realm.query<PlantObject>().find().mapNotNull { it.toPlant() }
    }
}