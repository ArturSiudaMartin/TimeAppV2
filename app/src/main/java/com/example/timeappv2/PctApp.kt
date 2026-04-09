package com.example.timeappv2

import PillNav
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@Composable
fun PctApp() {
    var currentPeriod by remember { mutableStateOf(TimePeriod.YEAR) }
    var now by remember { mutableStateOf(LocalDateTime.now()) }
    val timeState = remember(now) { calculateTimeState(now) }

    // Tick every minute
    LaunchedEffect(Unit) {
        while (true) {
            delay(60_000L)
            now = LocalDateTime.now()
        }
    }

    // Whole-screen background colour crossfades on period change
    val bgColor by animateColorAsState(
        targetValue = currentPeriod.background,
        animationSpec = tween(400),
        label = "bgColor"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .statusBarsPadding()
    ) {
        AnimatedContent(
            targetState = currentPeriod,
            transitionSpec = {
                val forward = targetState.ordinal > initialState.ordinal
                val dir = if (forward)
                    AnimatedContentTransitionScope.SlideDirection.Left
                else
                    AnimatedContentTransitionScope.SlideDirection.Right

                (slideIntoContainer(dir, tween(350, easing = EaseOutCubic)) +
                        fadeIn(tween(200))) togetherWith
                        (slideOutOfContainer(dir, tween(350, easing = EaseOutCubic)) +
                                fadeOut(tween(150)))
            },
            modifier = Modifier.weight(1f),
            label = "screenContent"
        ) { period ->
            when (period) {
                TimePeriod.YEAR  -> YearScreen(timeState, period)
                TimePeriod.MONTH -> print("Month")//MonthScreen(timeState, period)
                TimePeriod.WEEK  -> print("Week")//WeekScreen(timeState, period)
                TimePeriod.DAY   -> print("Day")//DayScreen(timeState, period)
                TimePeriod.HOUR  -> print("Hour")//HourScreen(timeState, period)
            }
        }

        PillNav(
            selected  = currentPeriod,
            onSelect  = { currentPeriod = it },
        )
    }
}