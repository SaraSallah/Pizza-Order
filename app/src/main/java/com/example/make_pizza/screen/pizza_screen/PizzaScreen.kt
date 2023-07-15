package com.example.make_pizza.screen.pizza_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.make_pizza.R
import com.example.make_pizza.composable.ButtonWithIcon
import com.example.make_pizza.composable.LazyRowIngredients
import com.example.make_pizza.composable.PagerContent
import com.example.make_pizza.composable.ReusableText
import com.example.make_pizza.composable.SelectPizzaSize
import com.example.make_pizza.composable.SpacerVertical
import com.example.make_pizza.ui.theme.SecondaryTextColor

@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.padding(bottom =4.dp)
            ,contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(.48f)
                    .fillMaxWidth()
            )
            Column() {
                PagerContent(state = state)
            }
        }

        SpacerVertical(height = 16.dp)
        ReusableText(text = "$17", color = Color.Black, fontSize = 32.sp)
        SpacerVertical(height = 24.dp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SelectPizzaSize(text = "S", modifier = Modifier, onClick = viewModel::onClickSmallSize)
            SelectPizzaSize(
                text = "M",
                modifier = Modifier,
                onClick = viewModel::onClickMediumSize
            )
            SelectPizzaSize(
                text = "L",
                modifier = Modifier,
                onClick = viewModel::onClickLargeSize
            )


        }
        SpacerVertical(height = 24.dp)

        LazyRowIngredients()
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
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
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