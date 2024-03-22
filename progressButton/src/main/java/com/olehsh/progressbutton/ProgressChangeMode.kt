package com.olehsh.progressbutton

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween

sealed class ProgressChangeMode {
  data object InstantChange : ProgressChangeMode()
  data class AnimatedChange(
    val animationSpec: AnimationSpec<Float> = tween(300, easing = LinearEasing)
  ) : ProgressChangeMode()
}
