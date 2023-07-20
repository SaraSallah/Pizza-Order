package com.example.make_pizza.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.make_pizza.screen.pizza_screen.IngredientsUiState
import com.example.make_pizza.screen.pizza_screen.PizzaUiState
import com.example.make_pizza.screen.pizza_screen.PizzaViewModel

@Composable
fun LazyRowIngredients(
    pizzaViewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by pizzaViewModel.state.collectAsState()
    LazyRowIng(state = state)

    }
@Composable
fun LazyRowIng(state: PizzaUiState) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(state.ingredients){
            IngredientsItem(state = it)
        }
    }
}

@Composable
fun IngredientsItem(state: IngredientsUiState) {
    Image(
        painter = rememberAsyncImagePainter(model = state.image),
        contentDescription = "character",
        Modifier
            .size(65.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Inside
    )

}