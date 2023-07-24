package com.example.make_pizza.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.make_pizza.screen.pizza_screen.IngredientsUiState


@Composable
fun LazyRowIng(
    ingredients: List<IngredientsUiState>,
    currentPizza: Int,
    onClickIngredient: (Int, Int, Boolean) -> Unit,
) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(count = ingredients.size) {
            IngredientsItem(
                ingredient = ingredients[it],
                currentPizza = currentPizza,
                onClick = onClickIngredient,
                index = it,
            )
        }
    }
}


@Composable
fun IngredientsItem(
    ingredient: IngredientsUiState,
    currentPizza: Int,
    onClick: (Int, Int, Boolean) -> Unit,
    index: Int,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (ingredient.isSelectedIngredient) Color(0xFFCAE6D6)
        else Color.Transparent, tween(300)
    )
    Image(
        painter = painterResource(id = ingredient.image),
        contentDescription = "character",
        Modifier
            .size(65.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(8.dp)
            .clickable { onClick(currentPizza, index, !ingredient.isSelectedIngredient) },
        contentScale = ContentScale.Inside
    )

}