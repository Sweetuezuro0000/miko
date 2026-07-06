package com.miko.app.voice

object WakeWordManager {

    private val wakeWords = listOf(

        "miko",

        "hey miko",

        "hello miko",

        "hi miko"

    )

    fun detected(

        text: String

    ): Boolean {

        val value = text.lowercase().trim()

        return wakeWords.any {

            value.startsWith(it)

        }

    }

}
