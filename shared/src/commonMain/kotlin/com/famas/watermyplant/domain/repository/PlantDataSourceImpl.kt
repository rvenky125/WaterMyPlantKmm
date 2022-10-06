package com.famas.watermyplant.domain.repository

import com.famas.watermyplant.data.repository.PlantDataSource
import com.famas.watermyplant.db.objects.PlantObject
import com.famas.watermyplant.db.realm
import com.famas.watermyplant.model.Plant
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find

class PlantDataSourceImpl: PlantDataSource {
    override suspend fun insertPlant(plant: Plant) {
        realm.write {
            copyToRealm(PlantObject().apply {
                name = plant.name
            })
        }
    }

    override suspend fun getAllPlants(): List<Plant> {
        return realm.query<PlantObject>().find().map { Plant(it.name) }
    }
}