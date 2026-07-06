package com.miko.app.data.note

class NoteRepository(

    private val dao: NoteDao

) {

    suspend fun save(

        title: String,

        content: String

    ) {

        dao.insert(

            Note(

                title = title,

                content = content

            )

        )

    }

    suspend fun getAll(): List<Note> {

        return dao.getAll()

    }

    suspend fun clear() {

        dao.deleteAll()

    }

}
