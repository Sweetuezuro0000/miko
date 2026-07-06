package com.miko.app.voice

object ConversationState {

    private var waitingForCommand = false

    fun start() {

        waitingForCommand = true

    }

    fun stop() {

        waitingForCommand = false

    }

    fun isWaiting(): Boolean {

        return waitingForCommand

    }

}
