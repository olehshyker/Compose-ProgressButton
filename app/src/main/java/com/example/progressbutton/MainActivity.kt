package com.example.progressbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progressbutton.ui.theme.AppTheme
import com.olehsh.progressapp.R
import com.olehsh.progressbutton.ProgressButton
import com.olehsh.progressbutton.ProgressChangeMode

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        SampleApp()
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
      .background(Color.White)
  ) {
    Text(
      text = stringResource(id = R.string.app_name),
      modifier = Modifier.align(Alignment.CenterHorizontally),
      fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
      fontSize = MaterialTheme.typography.h5.fontSize,
      style = TextStyle.Default.copy(color = Color.Black)
    )

    Spacer(modifier = Modifier.height(16.dp))

    val progress = remember { mutableFloatStateOf(0f) }

    ProgressButton(
      modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .fillMaxWidth()
        .height(64.dp),
      progress = progress.floatValue,
      textStyle = TextStyle.Default.copy(fontSize = 20.sp),
      buttonText = if (progress.floatValue < 100) "Press to update progress" else "Reset progress",
      fontResId = R.font.montserrat_semibold,
      progressChangeMode = ProgressChangeMode.AnimatedChange(),
      onClick = {
        if (progress.floatValue > 100) {
          progress.floatValue = 0f
        } else {
          progress.floatValue += 10f
        }
      }
    )

    Spacer(modifier = Modifier.height(16.dp))

    ProgressButton(
      modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .fillMaxWidth()
        .height(64.dp),
      progress = progress.floatValue,
      border = BorderStroke(2.dp, Color.Blue),
      textStyle = TextStyle.Default.copy(fontSize = 20.sp),
      buttonText = if (progress.floatValue < 100) "Press to update progress" else "Reset progress",
      fontResId = R.font.montserrat_semibold,
      progressChangeMode = ProgressChangeMode.AnimatedChange(),
      onClick = {
        if (progress.floatValue > 100) {
          progress.floatValue = 0f
        } else {
          progress.floatValue += 10f
        }
      }
    )
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AppTheme {
    SampleApp()
  }
}
