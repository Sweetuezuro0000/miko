package com.miko.app.ai

object CommandParser {

    fun parse(text: String): Command {

        val command = text.lowercase()

        return when {

            command == "miko" -> Command.UNKNOWN
            command == "hello miko" -> Command.UNKNOWN
            command == "hey miko" -> Command.UNKNOWN

            "flashlight on" in command ||
            "torch on" in command ||
            "light on" in command ||
            "light chalu" in command ||
            "torch chalu" in command ->
                Command.FLASHLIGHT_ON

            "flashlight off" in command ||
            "torch off" in command ||
            "light band" in command ||
            "torch band" in command ->
                Command.FLASHLIGHT_OFF

            "time" in command ||
            "kitne baje" in command ||
            "samay" in command ->
                Command.TIME

            "note" in command ||
            "notes" in command ->
                Command.NOTE

            "document" in command ||
            "documents" in command ||
            "pdf" in command ->
                Command.DOCUMENT

            "reminder" in command ||
            "alarm" in command ->
                Command.REMINDER

            "setting" in command ||
            "settings" in command ->
                Command.SETTINGS

            "search" in command ||
            "khojo" in command ->
                Command.SEARCH

            else -> Command.UNKNOWN
        }
    }
}
