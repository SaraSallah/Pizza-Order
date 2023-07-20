package com.example.make_pizza.screen.pizza_screen

data class PizzaUiState(
    val ingredients: List<IngredientsUiState> = emptyList(),
    val smallSelected: Boolean = false,
    val mediumSelected: Boolean = false,
    val largeSelected: Boolean = false,
)

data class IngredientsUiState(
    val image: Int,
    val name :String ="",
    var isSelectedIngredient: Boolean = false,

)


enum class ImageSizeState {
    SMALL,
    MEDIUM,
    LARGE
}