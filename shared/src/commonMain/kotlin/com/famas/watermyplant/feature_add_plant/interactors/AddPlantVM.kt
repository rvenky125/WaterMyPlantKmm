package com.famas.watermyplant.feature_add_plant.interactors

import com.famas.watermyplant.feature_add_plant.domain.repository.PlantRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddPlantVM(
    val plantRepository: PlantRepository,
) : ViewModel() {
    private val _addPlantStateFlow = MutableStateFlow(AddPlantState())
    val addPlantStateFlow: StateFlow<AddPlantState> = _addPlantStateFlow

    private val _actions = Channel<AddPlantAction>()
    val actions: Flow<AddPlantAction> get() = _actions.receiveAsFlow()

    fun onEvent(event: AddPlantEvent) {
        when (event) {
            is AddPlantEvent.SetName -> {
                _addPlantStateFlow.value = addPlantStateFlow.value.copy(name = event.name)
            }
            AddPlantEvent.OnSubmit -> {
                viewModelScope.launch {
                    _actions.send(AddPlantAction.ShowToast("Submit button clicked"))
                }
            }
        }
    }
}
