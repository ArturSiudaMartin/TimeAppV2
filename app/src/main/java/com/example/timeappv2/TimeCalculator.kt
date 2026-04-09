package com.example.timeappv2

import java.time.LocalDateTime
import java.time.temporal.IsoFields

data class TimeState(
    val yearPercent: Float,
    val monthPercent: Float,
    val weekPercent: Float,
    val dayPercent: Float,
    val hourPercent: Float,
    val dayOfYear: Int,
    val daysInYear: Int,
    val dayOfMonth: Int,
    val daysInMonth: Int,
    val dayOfWeek: Int,       // 1 = Monday
    val minuteOfDay: Int,
    val minuteOfHour: Int,
)

fun calculateTimeState(now: LocalDateTime): TimeState {
    val date = now.toLocalDate()

    val dayOfYear   = date.dayOfYear
    val daysInYear  = date.lengthOfYear()

    val dayOfMonth  = date.dayOfMonth
    val daysInMonth = date.lengthOfMonth()

    val dayOfWeek   = date.dayOfWeek.value   // 1–7

    val minuteOfDay  = now.hour * 60 + now.minute
    val minuteOfHour = now.minute

    return TimeState(
        yearPercent  = dayOfYear / daysInYear.toFloat(),
        monthPercent = dayOfMonth / daysInMonth.toFloat(),
        weekPercent  = dayOfWeek / 7f,
        dayPercent   = minuteOfDay / 1440f,
        hourPercent  = minuteOfHour / 60f,
        dayOfYear    = dayOfYear,
        daysInYear   = daysInYear,
        dayOfMonth   = dayOfMonth,
        daysInMonth  = daysInMonth,
        dayOfWeek    = dayOfWeek,
        minuteOfDay  = minuteOfDay,
        minuteOfHour = minuteOfHour,
    )
}