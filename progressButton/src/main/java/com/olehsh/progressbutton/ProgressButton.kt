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

/**
 * Composable function to display a ProgressButton with customizable attributes.
 *
 * @param modifier The modifier for the ProgressButton, which allows customization of layout and appearance.
 * @param onClick The lambda to be executed when the button is clicked.
 * @param progress The current progress value of the button.
 * @param minProgress The minimum progress value allowed for the button.
 * @param maxProgress The maximum progress value allowed for the button.
 * @param buttonText The text to be displayed on the button. If null, no text will be displayed.
 * @param elevation The elevation of the button, affecting its shadow appearance.
 * @param shape The shape of the button, defining its visual appearance and boundary.
 * @param border The border stroke of the button, specifying the appearance of the button's border.
 * @param textStyle The text style of the button's text, such as font, size, and color.
 * @param enabled Determines whether the button is enabled for user interaction.
 * @param buttonColors The colors of the button, including background, content, and border colors.
 * @param progressChangeMode The mode of progress change for the button.
 * @param fontResId The resource ID for the custom font to be used for the button's text.
 * @param interactionSource The interaction source for the button, tracking user interactions.
 * @param indication The indication for the button, providing visual feedback for user interactions.
 */
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
