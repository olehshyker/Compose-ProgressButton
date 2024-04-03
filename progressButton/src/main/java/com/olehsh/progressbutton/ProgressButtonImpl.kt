package com.olehsh.progressbutton

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer

@Composable
internal fun ProgressButtonImpl(
  onClick: () -> Unit,
  modifier: Modifier,
  progress: Float,
  minProgress: Float,
  maxProgress: Float,
  buttonText: String?,
  enabled: Boolean,
  elevation: ButtonElevation,
  shape: Shape,
  border: BorderStroke?,
  buttonColors: ProgressButtonColors,
  textStyle: TextStyle,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  indication: Indication? = null,
  progressChangeMode: ProgressChangeMode = ProgressChangeMode.AnimatedChange()
) {
  val coerced = progress.coerceIn(minProgress, maxProgress)

  val animatedProgress = remember {
    Animatable(
      if (progressChangeMode is ProgressChangeMode.AnimatedChange) minProgress else coerced
    )
  }

  LaunchedEffect(key1 = coerced) {
    if (progressChangeMode is ProgressChangeMode.AnimatedChange) {
      animatedProgress.animateTo(
        targetValue = coerced,
        animationSpec = progressChangeMode.animationSpec
      )
    } else {
      animatedProgress.snapTo(coerced)
    }
  }

  val textMeasurer = rememberTextMeasurer()
  val filledTextMeasurer = rememberTextMeasurer()

  // Drawing the button with progress and text
  Box(
    modifier = modifier
      .shadow(
        elevation.elevation(enabled, interactionSource).value,
        shape,
        clip = false
      )
      .then(if (border != null) Modifier.border(border, shape) else Modifier)
      .background(
        color = buttonColors.emptyBackgroundColor,
        shape = shape
      )
      .clip(shape)
      .clickable(
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        onClick = onClick
      )
      .drawBehind {
        drawProgressWithText(
          progress = animatedProgress.value,
          maxProgress = maxProgress,
          filledProgressColor = buttonColors.filledBackgroundColor,
          textColorOnFilled = buttonColors.textColorOnFilled,
          progressText = buttonText,
          textMeasurer = textMeasurer,
          filledTextMeasurer = filledTextMeasurer,
          textStyle = textStyle
        )
      }
  ) {
  }
}
