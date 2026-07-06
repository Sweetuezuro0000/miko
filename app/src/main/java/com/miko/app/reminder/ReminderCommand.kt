package com.miko.app.reminder

object ReminderCommand {

    fun isReminderCommand(

        text: String

    ): Boolean {

        val command = text.lowercase()

        return command.contains("reminder") ||
                command.contains("alarm") ||
                command.contains("yaad")

    }

}
