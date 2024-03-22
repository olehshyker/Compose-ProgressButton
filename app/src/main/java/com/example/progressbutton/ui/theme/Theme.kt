package com.example.progressbutton.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColors(
  primary = BlueGray,
  secondary = Blue
)

@Composable
fun AppTheme(
  content: @Composable () -> Unit
) {
  val colorScheme = LightColorScheme

  MaterialTheme(
    colors = colorScheme,
    typography = Typography,
    content = content
  )
}
