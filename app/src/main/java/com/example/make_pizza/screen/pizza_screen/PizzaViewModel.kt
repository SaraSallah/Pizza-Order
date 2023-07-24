package com.example.make_pizza.screen.pizza_screen

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
        _state.update { it.copy(pizzas = getInitPizzas()) }


    }
    fun onClickSmallSize(currentPizza: Int) {
        _state.update { currentState ->
            val updatedPizzas = currentState.pizzas.mapIndexed { index, pizza ->
                if (index == currentPizza) {
                    // Toggle the "Small" size selection for the current pizza
                    pizza.copy(
                        ingredients = pizza.ingredients.map { ingredient ->
                            ingredient.copy(
                                smallSelected = !ingredient.smallSelected,
                                mediumSelected = false,
                                largeSelected = false
                            )
                        }
                    )
                } else {
                    pizza
                }
            }
            currentState.copy(pizzas = updatedPizzas)
        }
    }


    fun onClickMediumSize(currentPizza: Int) {
        _state.update { currentState ->
            val updatedPizzas = currentState.pizzas.mapIndexed { index, pizza ->
                if (index == currentPizza) {
                    pizza.copy(
                        ingredients = pizza.ingredients.map { ingredient ->
                            ingredient.copy(
                                smallSelected = false,
                                mediumSelected = !ingredient.mediumSelected,
                                largeSelected = false
                            )
                        }
                    )
                } else {
                    pizza
                }
            }
            currentState.copy(pizzas = updatedPizzas)
        }
    }


    fun onClickLargeSize(currentPizza: Int) {
        _state.update { currentState ->
            val updatedPizzas = currentState.pizzas.mapIndexed { index, pizza ->
                if (index == currentPizza) {
                    pizza.copy(
                        ingredients = pizza.ingredients.map { ingredient ->
                            ingredient.copy(
                                smallSelected = false,
                                mediumSelected = false,
                                largeSelected = !ingredient.largeSelected)
                        }
                    )
                } else {
                    pizza
                }
            }
            currentState.copy(pizzas = updatedPizzas)
        }
    }

    private fun getInitPizzas(): List<PizzaIngredientsUiState> {
        return listOf(
            PizzaIngredientsUiState(R.drawable.bread_1, ingredients = getInitIngredients()),
            PizzaIngredientsUiState(R.drawable.bread_2, ingredients = getInitIngredients()),
            PizzaIngredientsUiState(R.drawable.bread_3, ingredients = getInitIngredients()),
            PizzaIngredientsUiState(R.drawable.bread_4, ingredients = getInitIngredients()),
            PizzaIngredientsUiState(R.drawable.bread_5, ingredients = getInitIngredients()),
        )
    }

    private fun getInitIngredients(): List<IngredientsUiState> {
        return listOf(
            IngredientsUiState(image = R.drawable.basil_2),
            IngredientsUiState(image = R.drawable.broccoli_1),
            IngredientsUiState(image = R.drawable.onion_2),
            IngredientsUiState(image = R.drawable.mushroom_6),
            IngredientsUiState(image = R.drawable.sausage_1)
        )
    }

    fun onIngredientClicked(currentPizza: Int, currentIngredient: Int, isSelected: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                pizzas = currentState.pizzas.toMutableList().apply {
                    val currentPizzaState = this[currentPizza]
                    val currentIngredients = currentPizzaState.ingredients.toMutableList()
                    val updatedIngredient = currentIngredients[currentIngredient]
                        .copy(isSelectedIngredient = isSelected)
                    currentIngredients[currentIngredient] = updatedIngredient
                    this[currentPizza] = currentPizzaState.copy(ingredients = currentIngredients)
                }
            )

        }
    }



}