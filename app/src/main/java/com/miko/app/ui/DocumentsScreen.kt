package com.miko.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miko.app.documents.Document

@Composable
fun DocumentsScreen(

    documents: List<Document>

) {

    LazyColumn {

        items(documents) { document ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {

                Column(

                    modifier = Modifier.padding(15.dp)

                ) {

                    Text(document.name)

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(document.type)

                }

            }

        }

    }

}
