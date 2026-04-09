package com.example.timeappv2

import androidx.compose.ui.geometry.Rect
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp

@Composable
fun PercentBar(
    percent: Float, // 0f..1f
    trackColor: androidx.compose.ui.graphics.Color,
    fillColor: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
) {
    val animatedPercent by animateFloatAsState(
        targetValue = percent,
        animationSpec = tween(durationMillis = 800, easing = EaseOutCubic)
    )

    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(3.dp)
    ) {
        val trackRect = RoundRect(
            rect = Rect(0f, 0f, size.width, size.height),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.height / 2)
        )
        drawRoundRect(color = trackColor, cornerRadius = androidx.compose.ui.geometry.CornerRadius(
            size.height / 2
        )
        )

        drawRoundRect(
            color = fillColor,
            size = Size(size.width * animatedPercent, size.height),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.height / 2)
        )
    }
}