package com.famas.watermyplant.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.famas.watermyplant.feature_add_plant.interactors.AddPlantAction
import com.famas.watermyplant.feature_add_plant.interactors.AddPlantEvent
import com.famas.watermyplant.feature_add_plant.interactors.AddPlantVM
import dev.icerock.moko.mvvm.flow.compose.observeAsActions
import org.koin.androidx.viewmodel.ext.android.getViewModel

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = getViewModel<AddPlantVM>()

        setContent {
            val state = viewModel.addPlantStateFlow.collectAsState()

            viewModel.actions.observeAsActions { action ->
                when (action) {
                    is AddPlantAction.ShowToast -> {
                        Toast.makeText(this, action.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        TextField(value = state.value.name, onValueChange = {
                            viewModel.onEvent(AddPlantEvent.SetName(it))
                        })

                        Button(onClick = { viewModel.onEvent(AddPlantEvent.OnSubmit) }) {
                            Text(text = "Submit")
                        }
                    }
                }
            }
        }
    }
}