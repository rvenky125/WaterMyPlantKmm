package com.famas.watermyplant.feature_add_plant.domain.mappers

import com.famas.watermyplant.db.objects.add_plant.PlantObject
import com.famas.watermyplant.model.Plant

fun PlantObject.toPlant(): Plant? {
    return Plant(
        name = name,
        description = description,
        shouldRemind = should_remind,
        colorHex = color_hex ?: return null,
        picUrl = pic_url ?: return null,
        waterQty = water_qty ?: return null,
        wateringFreaqMillis = watering_freaq_millis ?: return null,
        placeId = place_id ?: return null,
        createdAt = created_at ?: return null
    )
}

fun Plant.toPlantObject(): PlantObject {
    return PlantObject().apply {
        val plant = this@toPlantObject
        name = plant.name
        color_hex = plant.colorHex
        created_at = plant.createdAt
        description = plant.description
        pic_url = plant.picUrl
        place_id = plant.placeId
        should_remind = plant.shouldRemind
        created_at = plant.createdAt
        water_qty = plant.waterQty
        watering_freaq_millis = plant.wateringFreaqMillis
    }
}