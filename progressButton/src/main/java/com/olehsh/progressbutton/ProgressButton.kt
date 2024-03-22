package com.olehsh.progressbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProgressButton(
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {},
  progress: Float = ProgressButtonDefaults.MIN_PROGRESS,
  minProgress: Float = ProgressButtonDefaults.MIN_PROGRESS,
  maxProgress: Float = ProgressButtonDefaults.MAX_PROGRESS,
  buttonText: String? = null,
  elevation: Dp = 2.dp,
  shape: Shape = ProgressButtonDefaults.shape(),
  border: BorderStroke? = null,
  textStyle: TextStyle = TextStyle.Default,
  enabled: Boolean = true,
  buttonColors: ProgressButtonColors = ProgressButtonDefaults.buttonColors(),
  progressChangeMode: ProgressChangeMode = ProgressChangeMode.AnimatedChange(),
  fontResId: Int? = null,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  indication: Indication? = null
) {
  ProgressButtonImpl(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    elevation = ButtonDefaults.elevation(elevation),
    shape = shape,
    border = border,
    progress = progress,
    minProgress = minProgress,
    maxProgress = maxProgress,
    progressChangeMode = progressChangeMode,
    buttonColors = buttonColors,
    textStyle = textStyle,
    buttonText = buttonText,
    fontResId = fontResId,
    interactionSource = interactionSource,
    indication = indication
  )
}
