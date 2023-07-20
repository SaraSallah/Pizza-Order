package com.example.make_pizza.composable

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.make_pizza.ui.theme.Black80
import com.example.make_pizza.ui.theme.White60

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
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.size(width = 40.dp, height = 30.dp)
            .clickable { onClick()  },
        colors = CardDefaults.cardColors(containerColor = White),
        shape = CircleShape
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = Black,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReusableText() {
    CardSelected("rrr",{})
//    ReusableText()
//    SelectPizzaSize(
//        "Hi Every", modifier = Modifier, onClick = {}
//    )
}
