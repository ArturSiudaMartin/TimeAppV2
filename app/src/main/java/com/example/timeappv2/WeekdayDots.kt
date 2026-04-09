package com.example.timeappv2

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.Files.size

enum class DayState { PAST, CURRENT, FUTURE }

@Composable
fun DayDot(label: String, state: DayState, accentColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(label, fontFamily = dmmono, fontSize = 8.sp, color = Color(0xFF2D4A6A))

        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    when (state) {
                        DayState.PAST    -> accentColor
                        DayState.CURRENT -> Color(0xFF1A3A5C)
                        DayState.FUTURE  -> Color(0xFF131D2A)
                    }
                )
                .then(
                    if (state == DayState.CURRENT)
                        Modifier.border(1.dp, accentColor, RoundedCornerShape(8.dp))
                    else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                DayState.PAST -> {
                    // Draw a checkmark on canvas
                    Canvas(Modifier.size(10.dp)) {
                        drawLine(Color(0xFF0E1520), Offset(0f, size.height * 0.5f), Offset(size.width * 0.35f, size.height), strokeWidth = 3f, cap = StrokeCap.Round)
                        drawLine(Color(0xFF0E1520), Offset(size.width * 0.35f, size.height), Offset(size.width, 0f), strokeWidth = 3f, cap = StrokeCap.Round)
                    }
                }
                DayState.CURRENT -> Box(Modifier.size(6.dp).clip(CircleShape).background(accentColor))
                DayState.FUTURE  -> {}
            }
        }
    }
}