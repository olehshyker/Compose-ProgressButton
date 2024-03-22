package com.olehsh.progressbutton

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Shape

object ProgressButtonDefaults {

  const val MIN_PROGRESS: Float = 0f

  const val MAX_PROGRESS: Float = 100f

  @Composable
  fun shape(): Shape = remember {
    RoundedCornerShape(percent = 50)
  }

  @Composable
  fun buttonColors(): ProgressButtonColors = remember {
    ProgressButtonColors()
  }
}
