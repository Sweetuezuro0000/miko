package com.miko.app.voice

object MikoMemory {

    private var userName = ""

    private var lastCommand = ""

    fun setUserName(name: String) {

        userName = name

    }

    fun getUserName(): String {

        return userName

    }

    fun saveCommand(command: String) {

        lastCommand = command

    }

    fun lastCommand(): String {

        return lastCommand

    }

    fun hasUserName(): Boolean {

        return userName.isNotEmpty()

    }

}
