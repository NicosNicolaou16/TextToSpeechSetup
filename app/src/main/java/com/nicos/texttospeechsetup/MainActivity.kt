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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nicos.texttospeechsetup.ui.theme.TextToSpeechSetupTheme

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
                    TextToSpeechExample()
                }
            }
        }
    }
}

@Composable
fun TextToSpeechExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val textToSpeech = getInstanceTextToSpeech(context)

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Button(onClick = {
            textToSpeech.speak(
                context.getString(R.string.hello_im_nicos_nicolaou_and_i_just_show_the_simple_setup_for_text_to_speech),
                TextToSpeech.QUEUE_FLUSH,
                null,
                null
            )
        }) {
            Text(text = stringResource(R.string.click_text_to_speech))
        }
    }
}

/**
 * Get instance Text To Speech
 * */
fun getInstanceTextToSpeech(context: Context) = TextToSpeech(context) { status ->
    /**
     * Optional
     * */
    when (status) {
        TextToSpeech.ERROR_SYNTHESIS,
        TextToSpeech.ERROR,
        TextToSpeech.ERROR_SERVICE,
        TextToSpeech.ERROR_NETWORK,
        TextToSpeech.ERROR_NETWORK_TIMEOUT,
        TextToSpeech.ERROR_INVALID_REQUEST,
        TextToSpeech.ERROR_NOT_INSTALLED_YET,
        TextToSpeech.ERROR_OUTPUT -> {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
        }

        TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE -> {
            Toast.makeText(
                context,
                context.getString(R.string.language_country_var_available), Toast.LENGTH_SHORT
            ).show()
        }

        TextToSpeech.LANG_COUNTRY_AVAILABLE -> {
            Toast.makeText(
                context,
                context.getString(R.string.language_country_available), Toast.LENGTH_SHORT
            ).show()
        }

        TextToSpeech.LANG_AVAILABLE -> {
            Toast.makeText(
                context,
                context.getString(R.string.language_available), Toast.LENGTH_SHORT
            ).show()
        }

        TextToSpeech.LANG_MISSING_DATA -> {
            Toast.makeText(
                context,
                context.getString(R.string.language_missing_data), Toast.LENGTH_SHORT
            ).show()
        }

        TextToSpeech.LANG_NOT_SUPPORTED -> {
            Toast.makeText(
                context,
                context.getString(R.string.language_not_supported), Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Preview
@Composable
fun Preview() {
    TextToSpeechExample()
}