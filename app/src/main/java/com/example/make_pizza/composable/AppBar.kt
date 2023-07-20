package com.example.make_pizza.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.make_pizza.R
import com.example.make_pizza.ui.theme.Black80


@Preview(showSystemUi = true)
@Composable
fun AppBarWithIcon( modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonIcon(onClick = {}, painter = painterResource(id = R.drawable.baseline_arrow_back_24 ))
        Text(text ="Pizza", color = Black80, fontSize = 24.sp)
        ButtonIcon(onClick = {}, painter = painterResource(id = R.drawable.baseline_favorite_24 ))
        }

    }
