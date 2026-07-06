package com.miko.app.notes

import android.content.Context

class VoiceNote(

    context: Context

) {

    private val createNote = CreateNote(context)

    suspend fun saveFromVoice(

        speech: String

    ) {

        val title = "Voice Note"

        createNote.create(

            title,

            speech

        )

    }

}
