package com.example.timeappv2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import kotlin.math.roundToInt


@Composable
fun YearScreen(state: TimeState, theme: TimePeriod) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(Modifier.height(32.dp))

        // Wordmark
        Text("pct.", fontFamily = syne, fontSize = 13.sp,
            fontWeight = FontWeight.Bold, color = theme.textPrimary,
            letterSpacing = 0.06.sp)

        Spacer(Modifier.height(40.dp))

        // Period label
        Text("Year · ${LocalDate.now().year}",
            fontFamily = dmmono, fontSize = 10.sp,
            color = theme.textMuted, letterSpacing = 0.18.sp)

        Spacer(Modifier.height(12.dp))

        // Big number
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "${(state.yearPercent * 100).roundToInt()}",
                fontFamily = syne, fontSize = 72.sp,
                fontWeight = FontWeight.ExtraBold,
                color = theme.textPrimary, lineHeight = 72.sp
            )
            Text("%", fontFamily = syne, fontSize = 32.sp,
                color = theme.accent,
                modifier = Modifier.padding(bottom = 10.dp, start = 2.dp))
        }

        Text(
            "${state.dayOfYear} days elapsed · ${state.daysInYear - state.dayOfYear} remain",
            fontFamily = dmmono, fontSize = 11.sp,
            fontWeight = FontWeight.Light, color = theme.textMuted
        )

        Spacer(Modifier.height(32.dp))

        PercentBar(
            percent = state.yearPercent,
            trackColor = theme.trackColor,
            fillColor = theme.accent
        )

        // ... stat cards, etc.
    }
}