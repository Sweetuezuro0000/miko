package com.miko.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    var voiceEnabled by remember {
        mutableStateOf(true)
    }

    var status by remember {
        mutableStateOf("🟢 Ji, Main Sun Raha Hoon")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = "MIKO",
            style = MaterialTheme.typography.headlineLarge
        )

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Status")

                Text(status)

            }

        }

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Voice Assistant")

                Switch(
                    checked = voiceEnabled,
                    onCheckedChange = {

                        voiceEnabled = it

                        status =
                            if (it)
                                "🟢 Listening..."
                            else
                                "🔴 Voice Disabled"

                    }
                )

            }

        }

        Button(

            onClick = {

                status = "✅ Ho Gaya Ji"

            }

        ) {

            Text("Test Reply")

        }

    }

}
