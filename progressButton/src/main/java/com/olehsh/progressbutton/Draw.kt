package com.olehsh.progressbutton

import android.graphics.Rect
import android.text.TextPaint
import android.text.TextUtils
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas

/**
 * Draws a progress bar with optional text on a canvas.
 */
internal fun DrawScope.drawProgressWithText(
  progress: Float,
  maxProgress: Float,
  filledProgressColor: Color,
  progressText: String? = null,
  textPaint: TextPaint,
  filledTextPaint: TextPaint
) {
  // Calculate the width of the filled progress bar
  val filledProgressWidth = size.width * progress / maxProgress

  // Draw the filled progress rectangle
  drawRect(
    topLeft = Offset(0f, 0f),
    size = Size(filledProgressWidth, height = size.height),
    color = filledProgressColor
  )

  // Draw progress text if provided
  progressText?.let {
    // Calculate the vertical position of the text
    val yPos = (size.height / 2) - (textPaint.descent() + textPaint.ascent()) / 2

    // Crop text if it exceeds the width of the progress bar
    val croppedText = TextUtils.ellipsize(
      progressText,
      textPaint,
      size.width,
      TextUtils.TruncateAt.END
    ).toString()

    // Draw text on the canvas
    drawIntoCanvas { canvas ->

      with(canvas.nativeCanvas) {
        val rect = Rect()
        getClipBounds(rect)

        // Draw original text
        drawText(croppedText, size.width / 2, yPos, textPaint)

        // Clip the canvas to the filled portion of the progress bar
        rect.right = (filledProgressWidth).toInt()
        clipRect(rect)

        // Draw filled text within the clipped region
        drawText(croppedText, size.width / 2, yPos, filledTextPaint)
      }
    }
  }
}
