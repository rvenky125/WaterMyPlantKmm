package com.famas.watermyplant.feature_add_plant.interactors

sealed interface AddPlantAction {
    data class ShowToast(val message: String) : AddPlantAction
}