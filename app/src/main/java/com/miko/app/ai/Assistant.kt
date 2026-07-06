package com.miko.app.ai

data class AssistantResponse(

    val reply: String,

    val action: Command

)

object Assistant {

    fun process(text: String): AssistantResponse {

        val command = CommandParser.parse(text)

        return when (command) {

            Command.NOTE ->

                AssistantResponse(
                    ReplyEngine.working(),
                    Command.NOTE
                )

            Command.DOCUMENT ->

                AssistantResponse(
                    ReplyEngine.working(),
                    Command.DOCUMENT
                )

            Command.REMINDER ->

                AssistantResponse(
                    ReplyEngine.working(),
                    Command.REMINDER
                )

            Command.SETTINGS ->

                AssistantResponse(
                    ReplyEngine.working(),
                    Command.SETTINGS
                )

            Command.SEARCH ->

                AssistantResponse(
                    ReplyEngine.working(),
                    Command.SEARCH
                )

            else ->

                AssistantResponse(
                    ReplyEngine.error(),
                    Command.UNKNOWN
                )

        }

    }

}
