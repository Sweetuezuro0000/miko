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

            command == "miko" -> Command.UNKNOWN

            command == "hello miko" -> Command.UNKNOWN

            command == "hey miko" -> Command.UNKNOWN

            "note" in command -> Command.NOTE

            "notes" in command -> Command.NOTE

            "document" in command -> Command.DOCUMENT

            "documents" in command -> Command.DOCUMENT

            "pdf" in command -> Command.DOCUMENT

            "reminder" in command -> Command.REMINDER

            "alarm" in command -> Command.REMINDER

            "setting" in command -> Command.SETTINGS

            "settings" in command -> Command.SETTINGS

            "search" in command -> Command.SEARCH

            "khojo" in command -> Command.SEARCH

            else -> Command.UNKNOWN

        }

    }

}
