package com.nicos.texttospeechsetup

import android.content.Context
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
                    TextToSpeechView()
                }
            }
        }
    }
}

@Composable
fun TextToSpeechView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val textToSpeech = initTextToSpeech(context)

    Box(contentAlignment = Alignment.Center) {
        Button(onClick = {
            textToSpeech.speak("test demo", TextToSpeech.QUEUE_FLUSH, null, null)
        }) {
            Text(text = "Text To Speech Button")
        }
    }
}

/**
 * Get instance Text To Speech
 * */
fun initTextToSpeech(context: Context) = TextToSpeech(context) { status ->
    when (status) {
        TextToSpeech.ERROR_SYNTHESIS,
        TextToSpeech.ERROR,
        TextToSpeech.ERROR_SERVICE,
        TextToSpeech.ERROR_NETWORK,
        TextToSpeech.ERROR_NETWORK_TIMEOUT,
        TextToSpeech.ERROR_INVALID_REQUEST,
        TextToSpeech.ERROR_NOT_INSTALLED_YET,
        TextToSpeech.ERROR_OUTPUT -> {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE -> {
            Toast.makeText(context, "Language country var available", Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_COUNTRY_AVAILABLE -> {
            Toast.makeText(context, "Language country available", Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_AVAILABLE -> {
            Toast.makeText(context, "Language available", Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_MISSING_DATA -> {
            Toast.makeText(context, "Language missing data", Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_NOT_SUPPORTED -> {
            Toast.makeText(context, "Language not supported", Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun Preview() {
    TextToSpeechView()
}