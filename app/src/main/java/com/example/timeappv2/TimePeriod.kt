package com.example.timeappv2

import androidx.compose.ui.graphics.Color

enum class TimePeriod(
    val label: String,
    val background: Color,
    val accent: Color,
    val textPrimary: Color,
    val textMuted: Color,
    val trackColor: Color,
    val inactiveBorder: Color,
) {
    YEAR(
        label = "YEAR",
        background     = Color(0xFF0A0A0A),
        accent         = Color(0xFFC4F14A),
        textPrimary    = Color(0xFFFFFFFF),
        textMuted      = Color(0xFF444444),
        trackColor     = Color(0xFF1F1F1F),
        inactiveBorder = Color(0xFF222222),
    ),
    MONTH(
        label = "MONTH",
        background     = Color(0xFFF7F5F0),
        accent         = Color(0xFF1A1A1A),
        textPrimary    = Color(0xFF1A1A1A),
        textMuted      = Color(0xFFAAAAAA),
        trackColor     = Color(0xFFE8E4DC),
        inactiveBorder = Color(0xFFDDDDDD),
    ),
    WEEK(
        label = "WEEK",
        background     = Color(0xFF0E1520),
        accent         = Color(0xFF5BAAFF),
        textPrimary    = Color(0xFFC8E0F8),
        textMuted      = Color(0xFF2D4A6A),
        trackColor     = Color(0xFF131D2A),
        inactiveBorder = Color(0xFF1A3050),
    ),
    DAY(
        label = "DAY",
        background     = Color(0xFFFFFFFF),
        accent         = Color(0xFFFF5C35),
        textPrimary    = Color(0xFF111111),
        textMuted      = Color(0xFFCCCCCC),
        trackColor     = Color(0xFFF0F0F0),
        inactiveBorder = Color(0xFFEEEEEE),
    ),
    HOUR(
        label = "HOUR",
        background     = Color(0xFF0F0F0F),
        accent         = Color(0xFFA78BFA),
        textPrimary    = Color(0xFFFFFFFF),
        textMuted      = Color(0xFF333333),
        trackColor     = Color(0xFF1A1A1A),
        inactiveBorder = Color(0xFF1F1F1F),
    )
}