package com.miko.app.voice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer

class SpeechRecognizerManager(

    private val context: Context,

    private val onResult: (String) -> Unit

) {

    private val recognizer = SpeechRecognizer.createSpeechRecognizer(context)

    private val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {

        putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )

        putExtra(
            RecognizerIntent.EXTRA_LANGUAGE,
            "hi-IN"
        )

        putExtra(
            RecognizerIntent.EXTRA_PARTIAL_RESULTS,
            true
        )

    }

    init {

        recognizer.setRecognitionListener(object : RecognitionListener {

            override fun onReadyForSpeech(params: Bundle?) {}

            override fun onBeginningOfSpeech() {}

            override fun onRmsChanged(rmsdB: Float) {}

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {}

            override fun onEvent(eventType: Int, params: Bundle?) {}

            override fun onPartialResults(results: Bundle?) {}

            override fun onError(error: Int) {

                start()

            }

            override fun onResults(results: Bundle?) {

                val text = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()

                if (!text.isNullOrBlank()) {

                    onResult(text)

                }

                start()

            }

        })

    }

    fun start() {

        recognizer.startListening(intent)

    }

    fun stop() {

        recognizer.stopListening()

    }

    fun destroy() {

        recognizer.destroy()

    }

}
