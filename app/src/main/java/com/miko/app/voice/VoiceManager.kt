package com.miko.app.voice

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class VoiceManager(
    context: Context
) : TextToSpeech.OnInitListener {

    private val tts = TextToSpeech(context, this)

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {

            tts.language = Locale("hi", "IN")

            tts.setSpeechRate(1.0f)

        }

    }

    fun speak(text: String) {

        tts.speak(
            text,
            TextToSpeech.QUEUE_FLUSH,
            null,
            "MIKO"
        )

    }

    fun stop() {

        tts.stop()

    }

    fun destroy() {

        tts.stop()

        tts.shutdown()

    }

}
