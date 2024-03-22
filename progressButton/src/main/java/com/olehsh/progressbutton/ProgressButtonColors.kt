package com.olehsh.progressbutton

import androidx.compose.ui.graphics.Color

/**
 * Represents the colors used in a ProgressButton.
 *
 * @param emptyBackgroundColor The background color when the button is empty.
 * @param filledBackgroundColor The background color when the button is filled.
 * @param textColorOnEmpty The text color when the button is empty.
 * @param textColorOnFilled The text color when the button is filled.
 */
data class ProgressButtonColors(
  val emptyBackgroundColor: Color = Color.White,
  val filledBackgroundColor: Color = Color.Blue,
  val textColorOnEmpty: Color = Color.Black,
  val textColorOnFilled: Color = Color.White
)
