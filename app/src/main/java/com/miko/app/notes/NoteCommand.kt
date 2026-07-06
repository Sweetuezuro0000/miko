package com.miko.app.notes

object NoteCommand {

    fun isCreateCommand(

        text: String

    ): Boolean {

        val command = text.lowercase()

        return command.contains("note") ||

                command.contains("likho") ||

                command.contains("save")

    }

}
