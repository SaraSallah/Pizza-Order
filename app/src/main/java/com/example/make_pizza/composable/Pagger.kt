package com.example.make_pizza.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.make_pizza.R
import com.example.make_pizza.screen.pizza_screen.ImageSizeState
import com.example.make_pizza.screen.pizza_screen.PizzaUiState
import javax.annotation.meta.When


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerContent(state: PizzaUiState) {
    val pagerState = rememberPagerState()
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


@OptIn(ExperimentalFoundationApi::class)
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

        val targetSize = when {
            state.smallSelected -> animateDpAsState(220.dp)
            state.mediumSelected  -> animateDpAsState(270.dp)
            state.largeSelected  -> animateDpAsState(290.dp)
            else -> animateDpAsState(250.dp)
        }


        Image(
            painter = painterResource(id = images[it % images.size]),
            contentDescription = "",
            modifier = Modifier
                .scale(animatedScale)
                .clip(MaterialTheme.shapes.extraSmall)
                .size(targetSize.value)
        )
    }
}
