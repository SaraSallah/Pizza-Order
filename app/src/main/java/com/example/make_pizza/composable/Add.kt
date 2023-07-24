package com.example.make_pizza.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import com.example.make_pizza.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ImageRegion(selected: Boolean) {
    val images = listOf(
        R.drawable.basil_1,
        R.drawable.basil_2,
        R.drawable.basil_3,
        R.drawable.basil_3,
        R.drawable.basil_4,
        R.drawable.basil_5,
        R.drawable.basil_6,
        R.drawable.basil_7,
        R.drawable.basil_8,
        R.drawable.basil_9,
        R.drawable.basil_10,
        )

    val transition = updateTransition(targetState = selected, label = "visibilityTransition")

    val alpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) }, label = ""
    ) { if (it) 1f else 0f }

    val offset by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) }, label = ""
    ) { if (it) 0f else 1000f }

    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer(alpha = alpha, translationX = offset)
    ) {
        images.forEach { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
