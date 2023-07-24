package com.example.make_pizza.screen.pizza_screen

import com.example.make_pizza.R

data class PizzaUiState(
    val pizzas: List<PizzaIngredientsUiState> = emptyList(),
    val ingredients: List<IngredientsUiState> = emptyList(),
//    val smallSelected: Boolean = false,
//    val mediumSelected: Boolean = false,
//    val largeSelected: Boolean = false,
)
data class PizzaIngredientsUiState(
    val image: Int ,
    val ingredients :List<IngredientsUiState> = emptyList(),

)

data class IngredientsUiState(
    val image: Int,
    val name :String ="",
    var isSelectedIngredient: Boolean = false,
    val largeSelected: Boolean = false,
    val smallSelected: Boolean = false,
    val mediumSelected: Boolean = false,
    ){
fun addIngredient(): Int{
    return when(image){
        R.drawable.basil_2 -> R.drawable.basil
        R.drawable.broccoli_1 -> R.drawable.broccoli
        R.drawable.onion_2 -> R.drawable.onion
        R.drawable.mushroom_6 -> R.drawable.mushroom
        R.drawable.sausage_1 -> R.drawable.sausage
        else -> R.drawable.sausage
    }
}
}
