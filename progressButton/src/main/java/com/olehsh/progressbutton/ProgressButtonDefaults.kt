package com.olehsh.progressbutton

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Shape

/**
 * Default values for the ProgressButton.
 */
object ProgressButtonDefaults {

  /** The minimum progress value. */
  const val MIN_PROGRESS: Float = 0f

  /** The maximum progress value. */
  const val MAX_PROGRESS: Float = 100f

  /**
   * Provides the default shape for the ProgressButton.
   *
   * @return The default shape.
   */
  @Composable
  fun shape(): Shape = remember {
    RoundedCornerShape(percent = 50)
  }

  /**
   * Provides the default button colors for the ProgressButton.
   *
   * @return The default button colors.
   */
  @Composable
  fun buttonColors(): ProgressButtonColors = remember {
    ProgressButtonColors()
  }
}
