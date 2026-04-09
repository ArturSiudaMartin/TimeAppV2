package com.example.timeappv2

import androidx.compose.ui.graphics.Color
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ArcRing(
    percent: Float,
    trackColor: Color,
    fillColor: Color,
    strokeWidth: Dp = 10.dp,
    modifier: Modifier = Modifier
) {
    val animatedSweep by animateFloatAsState(
        targetValue = percent * 360f,
        animationSpec = tween(durationMillis = 1000, easing = EaseOutCubic)
    )

    Canvas(modifier = modifier.size(180.dp)) {
        val stroke = Stroke(
            width = strokeWidth.toPx(),
            cap = StrokeCap.Round   // gives the rounded tip seen on the Month screen
        )
        val inset = strokeWidth.toPx() / 2

        // Track (full grey ring)
        drawArc(
            color = trackColor,
            startAngle = -90f,   // start at 12 o'clock
            sweepAngle = 360f,
            useCenter = false,
            topLeft = Offset(inset, inset),
            size = Size(size.width - inset * 2, size.height - inset * 2),
            style = stroke
        )

        // Coloured fill arc
        drawArc(
            color = fillColor,
            startAngle = -90f,
            sweepAngle = animatedSweep,
            useCenter = false,
            topLeft = Offset(inset, inset),
            size = Size(size.width - inset * 2, size.height - inset * 2),
            style = stroke
        )
    }
}