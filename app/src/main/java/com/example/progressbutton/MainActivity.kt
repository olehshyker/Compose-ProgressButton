package com.example.progressbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progressbutton.ui.theme.AppTheme
import com.olehsh.progressapp.R
import com.olehsh.progressbutton.ProgressButton
import com.olehsh.progressbutton.ProgressButtonDefaults
import com.olehsh.progressbutton.ProgressChangeMode
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        Scaffold(
          topBar = {
            TopAppBar(
              title = {
                Text(text = stringResource(id = R.string.app_name))
              },
              backgroundColor = MaterialTheme.colors.primary,
              contentColor = Color.White,
              elevation = 2.dp
            )
          },
          content = { padding ->
            SampleApp(
              modifier = Modifier.padding(padding)
            )
          }
        )
      }
    }
  }
}

@Composable
fun SampleApp(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    StartButtonExample()

    Spacer(modifier = Modifier.height(16.dp))
  }
}

@Composable
fun StartButtonExample() {
  val animatedProgress = remember {
    Animatable(
      ProgressButtonDefaults.MIN_PROGRESS
    )
  }

  val scope = rememberCoroutineScope()

  val buttonText = when (animatedProgress.value) {
    0f -> {
      stringResource(id = R.string.txt_start)
    }

    100f -> {
      stringResource(id = R.string.txt_done)
    }

    else -> {
      stringResource(id = R.string.txt_downloading)
    }
  }

  ProgressButton(
    modifier = Modifier
      .fillMaxWidth()
      .height(64.dp),
    progress = animatedProgress.value,
    textStyle = TextStyle.Default.copy(fontSize = 20.sp),
    buttonText = buttonText,
    fontResId = R.font.montserrat_semibold,
    progressChangeMode = ProgressChangeMode.InstantChange,
    onClick = {
      scope.launch {
        if (animatedProgress.value == ProgressButtonDefaults.MAX_PROGRESS) {
          animatedProgress.snapTo(ProgressButtonDefaults.MIN_PROGRESS)
        } else {
          animatedProgress.animateTo(
            ProgressButtonDefaults.MAX_PROGRESS,
            tween(4000, easing = LinearEasing)
          )
        }
      }
    }
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AppTheme {
    SampleApp()
  }
}
