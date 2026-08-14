# Text To Speech Setup

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This project demonstrates the setup for **Text-to-Speech** on Android using Jetpack Compose and Kotlin. It shows how to initialize a `TextToSpeech` instance, handle status callbacks, and speak a text string with a simple button.

> [!IMPORTANT]
> A detailed step-by-step guide is available on Medium!  
> 👉 **[Text To Speech Setup For Android](https://medium.com/@nicosnicolaou/text-to-speech-setup-for-android-109c342ecdd1)** 👈

## 🚀 Setup Steps

### 1. Initialize the Text-to-Speech Instance

Initialize and get an instance for Text To Speech:

```kotlin
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

### 2. Speak the Text

Initialize the `speak(...)` method and pass a text:

```kotlin
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

## 🔧 Versioning

- **Target SDK:** **37**
- **Minimum SDK:** **29**
- **Kotlin Version:** **2.4.10**
- **Gradle Version:** **9.3.1**

## 📚 References & Tutorials

- **Documentation:** [TextToSpeech - Android Developers](https://developer.android.com/reference/kotlin/android/speech/tts/TextToSpeech)
- **Article:** [Text To Speech Setup For Android - Medium](https://medium.com/@nicosnicolaou/text-to-speech-setup-for-android-109c342ecdd1)

## ⭐ Stargazers

If you enjoy this project, please give it a star!
Check out all the stargazers here: [Stargazers on GitHub](https://github.com/NicosNicolaou16/TextToSpeechSetup/stargazers)

## 🙏 Support & Contributions

This project is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.