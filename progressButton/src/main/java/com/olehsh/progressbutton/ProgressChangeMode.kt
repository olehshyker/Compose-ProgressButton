package com.olehsh.progressbutton

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween

/**
 * A sealed class representing different modes for changing progress in a ProgressButton.
 */
sealed class ProgressChangeMode {

  /**
   * Represents an instant change mode where progress instantly changes to the specified value.
   */
  data object InstantChange : ProgressChangeMode()

  /**
   * Represents an animated change mode where progress transitions to the specified value with animation.
   *
   * @param animationSpec The animation specification defining the animation parameters.
   */
  data class AnimatedChange(
    val animationSpec: AnimationSpec<Float> = tween(300, easing = LinearEasing)
  ) : ProgressChangeMode()
}
