package com.tala.core_design.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Primary,
    secondary = Ascent,
    background = Color.Black,
    surface = Color.Black,
    onSurface = Color.White,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = DarkPrimary,
    primaryVariant = Primary,
    secondary = Ascent,
    background = Color.White,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun TalaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors, shapes = Shapes, content = content
    )
}