package com.miko.app.notes

import android.content.Context
import com.miko.app.data.DatabaseProvider
import com.miko.app.data.note.NoteRepository

class CreateNote(

    context: Context

) {

    private val repository = NoteRepository(

        DatabaseProvider
            .getDatabase(context)
            .noteDao()

    )

    suspend fun create(

        title: String,

        content: String

    ) {

        repository.save(

            title,

            content

        )

    }

}
