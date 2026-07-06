package com.miko.app.voice

object ConversationManager {

    private var active = false

    fun startConversation() {

        active = true

    }

    fun stopConversation() {

        active = false

    }

    fun isActive(): Boolean {

        return active

    }

}
