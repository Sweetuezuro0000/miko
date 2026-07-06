package com.miko.app.ai

enum class Command {

    NOTE,

    DOCUMENT,

    REMINDER,

    SETTINGS,

    SEARCH,

    UNKNOWN

}

object CommandParser {

    fun parse(text: String): Command {

        val command = text.lowercase()

        return when {

            "note" in command -> Command.NOTE

            "document" in command -> Command.DOCUMENT

            "pdf" in command -> Command.DOCUMENT

            "reminder" in command -> Command.REMINDER

            "setting" in command -> Command.SETTINGS

            "search" in command -> Command.SEARCH

            else -> Command.UNKNOWN

        }

    }

}
