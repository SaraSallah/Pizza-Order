package com.example.make_pizza.screen.pizza_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.make_pizza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    init {
        getAllIngredient()

    }
    fun onClickSmallSize(){
        _state.update {
            it.copy(
                smallSelected = !it.smallSelected,
                mediumSelected = false,
                largeSelected = false,

            )
        }
    }
    fun onClickMediumSize(){
        _state.update {
            it.copy(
                smallSelected = false,
                mediumSelected = !it.mediumSelected,
                largeSelected = false,
            )
        }

    }
    fun onClickLargeSize(){
        _state.update {
            it.copy(
                smallSelected = false,
                mediumSelected = false,
                largeSelected = !it.largeSelected,
            )
        }
    }

    private fun getAllIngredient() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    IngredientsUiState(R.drawable.basil_2,"basil"),
                    IngredientsUiState(R.drawable.onion_3,"onion"),
                    IngredientsUiState(R.drawable.broccoli_3,"broccoli"),
                    IngredientsUiState(R.drawable.mushroom_3,"mushroom"),
                    IngredientsUiState(R.drawable.sausage_3,"sausage"),
                    IngredientsUiState(R.drawable.basil_1,"basil"),
                    IngredientsUiState(R.drawable.onion_3,"onion"),

                    )
            )
        }
    }
}