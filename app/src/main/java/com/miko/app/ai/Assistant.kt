package com.miko.app.ai

data class AssistantResponse(

    val reply: String,

    val action: Command

)

object Assistant {

    fun process(

        text: String

    ): AssistantResponse {

        val command = CommandParser.parse(text)

        return when (command) {

            Command.NOTE ->

                AssistantResponse(

                    "Ji, note bana raha hoon.",

                    Command.NOTE

                )

            Command.DOCUMENT ->

                AssistantResponse(

                    "Ji, documents khol raha hoon.",

                    Command.DOCUMENT

                )

            Command.REMINDER ->

                AssistantResponse(

                    "Ji, reminder bana raha hoon.",

                    Command.REMINDER

                )

            Command.SETTINGS ->

                AssistantResponse(

                    "Ji, settings khol raha hoon.",

                    Command.SETTINGS

                )

            Command.SEARCH ->

                AssistantResponse(

                    "Ji, search kar raha hoon.",

                    Command.SEARCH

                )

            else ->

                AssistantResponse(

                    "Maaf kijiye, mujhe samajh nahi aaya.",

                    Command.UNKNOWN

                )

        }

    }

}
