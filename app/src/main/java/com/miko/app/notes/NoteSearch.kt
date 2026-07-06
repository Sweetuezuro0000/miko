package com.miko.app.notes

import com.miko.app.data.note.Note

object NoteSearch {

    fun search(

        notes: List<Note>,

        query: String

    ): List<Note> {

        return notes.filter {

            it.title.contains(query, true) ||

            it.content.contains(query, true)

        }

    }

}
