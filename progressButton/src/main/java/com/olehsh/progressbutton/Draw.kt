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

/** This method draws current progress and button text */
internal fun DrawScope.drawProgressWithText(
  progress: Float,
  maxProgress: Float,
  filledProgressColor: Color,
  progressText: String? = null,
  textPaint: TextPaint,
  filledTextPaint: TextPaint
) {
  drawRect(
    topLeft = Offset(0f, 0f),
    size = Size(size.width * progress / maxProgress, height = size.height),
    color = filledProgressColor
  )

  progressText?.let {
    val yPos = (size.height / 2) - (textPaint.descent() + textPaint.ascent()) / 2

    val croppedText = TextUtils.ellipsize(
      progressText,
      textPaint,
      size.width,
      TextUtils.TruncateAt.END
    ).toString()

    drawIntoCanvas { canvas ->

      with(canvas.nativeCanvas) {
        val rect = Rect()
        getClipBounds(rect)

        drawText(croppedText, size.width / 2, yPos, textPaint)

        rect.right = (rect.width() * progress / maxProgress).toInt()

        clipRect(rect)

        drawText(croppedText, size.width / 2, yPos, filledTextPaint)
      }
    }
  }
}
