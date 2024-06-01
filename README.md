# Text To Speech Setup

This project shows the setup for the Text To Speech.

Target SDK version: 34 <br />
Minimum SDK version: 27 <br />
Kotlin version: 2.0.0 <br />
Gradle version: 8.4.1 <br />

## Step 1:

## Check my article

Initialize and get instance for Text To Speech <br />

```Kotlin
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
```

## Step 2:

Initialize the method speak(...) and pass a text

```Kotlin
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
```

## Check my article

https://medium.com/@nicosnicolaou/text-to-speech-setup-for-android-109c342ecdd1 <br />

# References

https://developer.android.com/reference/kotlin/android/speech/tts/TextToSpeech <br />