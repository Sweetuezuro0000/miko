package com.miko.app.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miko.app.data.note.Note
import com.miko.app.data.note.NoteRepository
import kotlinx.coroutines.launch

class NotesViewModel(

    private val repository: NoteRepository

) : ViewModel() {

    var notes by mutableStateOf<List<Note>>(emptyList())
        private set

    fun loadNotes() {

        viewModelScope.launch {

            notes = repository.getAll()

        }

    }

}
