package ru.testtask.handservice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.testtask.handservice.ui.screens.main.MainScreen
import ru.testtask.handservice.ui.theme.HandServiceTestTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandServiceTestTaskTheme {
                MainScreen()
            }
        }
    }
}