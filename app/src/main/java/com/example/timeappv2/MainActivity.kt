package com.example.timeappv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.timeappv2.ui.theme.TimeAppV2Theme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeAppV2Theme {
                val state = calculateTimeState(LocalDateTime.now())
                YearScreen(state = state, theme = TimePeriod.YEAR)
            }
        }
    }
}