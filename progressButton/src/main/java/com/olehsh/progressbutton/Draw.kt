package com.olehsh.progressbutton

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints

/**
 * Draws a progress bar with optional text on a canvas.
 */
internal fun DrawScope.drawProgressWithText(
  progress: Float,
  maxProgress: Float,
  filledProgressColor: Color,
  textColorOnFilled: Color,
  progressText: String? = null,
  textMeasurer: TextMeasurer,
  filledTextMeasurer: TextMeasurer,
  textStyle: TextStyle
) {
  // Calculate the width of the filled progress bar
  val filledProgressWidth = size.width * progress / maxProgress

  // Draw the filled progress rectangle
  drawRect(
    topLeft = Offset(0f, 0f),
    size = Size(filledProgressWidth, height = size.height),
    color = filledProgressColor
  )

  val textLayoutResult: TextLayoutResult =
    textMeasurer.measure(
      text = AnnotatedString(progressText.orEmpty()),
      style = textStyle,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      constraints = Constraints(maxWidth = size.width.toInt())
    )

  val filledTextLayoutResult: TextLayoutResult =
    filledTextMeasurer.measure(
      text = AnnotatedString(progressText.orEmpty()),
      style = textStyle.copy(color = textColorOnFilled),
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      constraints = Constraints(maxWidth = size.width.toInt())
    )

  val xPos = (size.width - textLayoutResult.size.width) / 2
  val yPos =
    (size.height - textLayoutResult.size.height) / 2 // Adjust for descent

  // Draw text on filled part
  clipRect(
    left = filledProgressWidth
  ) {
    drawText(
      textLayoutResult = textLayoutResult,
      topLeft = Offset(xPos, yPos)
    )
  }

  // Draw text on unfilled part
  clipRect(
    right = filledProgressWidth
  ) {
    drawText(
      textLayoutResult = filledTextLayoutResult,
      topLeft = Offset(xPos, yPos)
    )
  }
}
