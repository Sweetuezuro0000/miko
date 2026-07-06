package com.miko.app.ai

import kotlin.random.Random

object ReplyEngine {

    private val listening = listOf(
        "Ji, main sun raha hoon.",
        "Haan ji, boliye.",
        "Ji?",
        "Main tayyar hoon."
    )

    private val working = listOf(
        "Ji, karta hoon.",
        "Ek second.",
        "Abhi karta hoon.",
        "Theek hai ji."
    )

    private val success = listOf(
        "Ho gaya ji.",
        "Kaam poora ho gaya.",
        "Ye lijiye.",
        "Done ji."
    )

    private val error = listOf(
        "Maaf kijiye.",
        "Command samajh nahi aayi.",
        "Dobara boliye."
    )

    fun listening() = listening.random()

    fun working() = working.random()

    fun success() = success.random()

    fun error() = error.random()
}
