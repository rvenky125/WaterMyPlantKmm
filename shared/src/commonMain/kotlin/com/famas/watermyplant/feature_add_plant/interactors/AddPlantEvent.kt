package com.famas.watermyplant.feature_add_plant.interactors

sealed interface AddPlantEvent {
    data class SetName(val name: String): AddPlantEvent
    object OnSubmit: AddPlantEvent
}