package com.miko.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miko.app.data.note.Note

@Composable
fun NotesScreen(

    notes: List<Note>

) {

    LazyColumn(

        modifier = Modifier.fillMaxSize()

    ) {

        items(notes) { note ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {

                Column(

                    modifier = Modifier.padding(15.dp)

                ) {

                    Text(note.title)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(note.content)

                }

            }

        }

    }

}
