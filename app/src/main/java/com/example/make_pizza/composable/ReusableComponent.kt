package com.example.make_pizza.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.make_pizza.ui.theme.Black80
import com.example.make_pizza.ui.theme.White38
import com.example.make_pizza.ui.theme.White8
import com.example.make_pizza.ui.theme.White87

@Composable
fun ReusableText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.SemiBold,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.wrapContentSize()
    )
}

@Composable
fun ButtonWithIcon(
    iconResId: Int,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.wrapContentSize(),
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null, tint = Color.White
            )
            SpacerHorizontal(8.dp)
            Text(
                text = text,
                color = Color.White
            )

        }
    }
}
@Composable
fun ButtonIcon(modifier: Modifier = Modifier,
               onClick: () -> Unit = {}, painter: Painter) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(32.dp)

    ) {
        Icon(
            painter = painter,
            contentDescription = null, tint = Black80
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectPizzaSize(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit,

) {
    Button(
        modifier=Modifier.size(width = 40.dp, height = 40.dp),
        shape = RoundedCornerShape(16.dp) ,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ReusableText(
                text = text,
                color = Black80,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )


        }

    }


}
@Composable
fun CardSelected(
    title: String,
    currentPizza: Int,
    onClick: (currentPizza: Int) -> Unit,
) {
    Button(
        modifier = Modifier.size(50.dp),
        onClick = { onClick(currentPizza) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        shape = CircleShape
    ) {

            Text(
                text = title,
                fontSize = 24.sp,
                color = Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewReusableText() {

}
