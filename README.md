# Compose-ProgressButton

Simple progress button with animation, written using Jetpack Compose.

![image](/assets/images/button-image.jpg)

## Definition

```kotlin
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
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  indication: Indication? = null,
)
```

## Usage example

![image](/assets/images/movie-app-usage-example.jpg)
