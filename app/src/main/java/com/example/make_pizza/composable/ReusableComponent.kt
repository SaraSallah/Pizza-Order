package com.example.make_pizza.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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



@Composable
fun CardSelected(
    text: String,
    currentPizza: Int,
    onClick: (currentPizza: Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .clip(CircleShape)
            .size(45.dp)
            .clickable { onClick(currentPizza)  },
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 16.dp, top = 6.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewReusableText() {

}
