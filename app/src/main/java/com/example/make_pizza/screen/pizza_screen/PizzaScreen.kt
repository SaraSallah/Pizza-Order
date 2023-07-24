package com.example.make_pizza.screen.pizza_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.make_pizza.R
import com.example.make_pizza.composable.AppBarWithIcon
import com.example.make_pizza.composable.ButtonWithIcon
import com.example.make_pizza.composable.CardSelected
import com.example.make_pizza.composable.LazyRowIng
import com.example.make_pizza.composable.PagerContent
import com.example.make_pizza.composable.ReusableText
import com.example.make_pizza.composable.SpacerVertical
import com.example.make_pizza.ui.theme.SecondaryTextColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppBarWithIcon(modifier = Modifier.padding(horizontal = 24.dp))

        Box(modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .padding(horizontal = 16.dp)) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.Center).padding(24.dp)
                    .size(300.dp)
                    .paint(painter = painterResource(id = R.drawable.plate))
            )
            Column(
                Modifier
                    .padding(bottom = 8.dp)
                    .align(alignment = Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                PagerContent(state = state, pagerState = pagerState)
            }
        }

        SpacerVertical(height = 14.dp)
        ReusableText(text = "$17", color = Color.Black, fontSize = 32.sp)
        SpacerVertical(height = 16.dp)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CardSelected(
                text = "S",
                onClick = viewModel::onClickSmallSize,
                currentPizza = pagerState.currentPage,
            )
            CardSelected(
                text = "M",
                onClick = viewModel::onClickMediumSize,
                currentPizza = pagerState.currentPage,
            )
            CardSelected(
                text = "L",
                onClick = viewModel::onClickLargeSize,
                currentPizza = pagerState.currentPage,
            )

        }
        SpacerVertical(height = 16.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            ReusableText(
                text = "CUSTOMIZE YOUR PIZZA",
                color = SecondaryTextColor,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
        SpacerVertical(height = 16.dp)


        LazyRowIng(
            ingredients = state.pizzas[pagerState.currentPage].ingredients,
            currentPizza = pagerState.currentPage,
            onClickIngredient = viewModel::onIngredientClicked
        )

        SpacerVertical(height = 24.dp)
        Spacer(modifier = Modifier.weight(1f))


        ButtonWithIcon(iconResId = R.drawable.buy, text = "Add To Cart") {

        }
        SpacerVertical(height = 24.dp)


    }


}

@Preview(showBackground = true)
@Composable
fun PreviewPizzaScreen() {
    PizzaScreen()

}