package com.miko.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miko.app.data.note.Note
import com.miko.app.data.note.NoteDao

@Database(

    entities = [
        Note::class
    ],

    version = 1,

    exportSchema = false

)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}
