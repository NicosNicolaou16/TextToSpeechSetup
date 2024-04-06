package com.nicos.texttospeechsetup

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.nicos.texttospeechsetup.ui.theme.TextToSpeechSetupTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextToSpeechSetupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextToSpeech()
                }
            }
        }
    }
}

@Composable
fun TextToSpeech(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val textToSpeech = TextToSpeech(context) { status -> }

    Box(contentAlignment = Alignment.Center) {
        Button(onClick = {
            textToSpeech.speak("test demo", TextToSpeech.QUEUE_FLUSH, null, null)
        }) {
            Text(text = "Text To Speech Button")
        }
    }
}

@Preview
@Composable
fun Preview() {
    TextToSpeech()
}