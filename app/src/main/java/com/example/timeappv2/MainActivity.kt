package com.example.timeappv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.timeappv2.ui.theme.TimeAppV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeAppV2Theme {
                HelloWorldScreen()
            }
        }
    }
}

@Composable
fun HelloWorldScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello World")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    TimeAppV2Theme {
        HelloWorldScreen()
    }
}