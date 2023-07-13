package com.example.make_pizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.make_pizza.screen.pizza_screen.PizzaScreen
import com.example.make_pizza.ui.theme.Make_PizzaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Make_PizzaTheme {
                PizzaScreen()

            }
        }
    }
}
