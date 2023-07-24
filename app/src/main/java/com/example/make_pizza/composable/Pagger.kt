package com.example.make_pizza.composable

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.make_pizza.R
import com.example.make_pizza.screen.pizza_screen.PizzaUiState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerContent(
    state: PizzaUiState, pagerState: PagerState,
) {
    val images = listOf(
        R.drawable.bread_1, R.drawable.bread_2,
        R.drawable.bread_3, R.drawable.bread_4
    )

    HorizontalImages(
        state = state,
        onClickImage = { },
        pagerState = pagerState,
        images = images,
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 24.dp)
    )

}


@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HorizontalImages(
    state: PizzaUiState,
    onClickImage: (Any?) -> Unit,

    pagerState: PagerState,
    images: List<Int>,
    modifier: Modifier = Modifier,
) {


    HorizontalPager(
        state = pagerState,
        pageCount = images.size,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        val animatedScale by animateFloatAsState(
            targetValue = if (it == pagerState.currentPage) 1f else 0.6f,
            animationSpec = tween(durationMillis = 200)
        )
        state.pizzas[it].ingredients.forEach {size ->

        val targetSize = when {
            size.smallSelected -> animateDpAsState(180.dp)
            size.mediumSelected -> animateDpAsState(220.dp)
            size.largeSelected -> animateDpAsState(250.dp)
            else -> animateDpAsState(200.dp)
        }

        Box {
            Image(
                painter = painterResource(id = state.pizzas[it].image),
                contentDescription = "",
                modifier = Modifier
                    .scale(animatedScale)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .size(targetSize.value)
            )
            state.pizzas[it].ingredients.forEach {
                AnimatedVisibility(
                    visible = it.isSelectedIngredient,
                    enter = scaleIn(initialScale = 80f),
                    exit = ExitTransition.None
                ) {
                    Image(
                        modifier = Modifier
                            .size(targetSize.value),
                        painter = painterResource(id = it.addIngredient()),
                        contentDescription = ""
                    )}
                }
            }
        }
    }
}

