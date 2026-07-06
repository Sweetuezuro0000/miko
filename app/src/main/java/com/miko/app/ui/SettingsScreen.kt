package com.miko.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miko.app.data.AppSettings

@Composable
fun SettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Voice Assistant")

                Switch(
                    checked = AppSettings.voiceEnabled,
                    onCheckedChange = {
                        AppSettings.voiceEnabled = it
                    }
                )

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Speak Replies")

                Switch(
                    checked = AppSettings.speakReply,
                    onCheckedChange = {
                        AppSettings.speakReply = it
                    }
                )

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Auto Listening")

                Switch(
                    checked = AppSettings.autoListen,
                    onCheckedChange = {
                        AppSettings.autoListen = it
                    }
                )

            }

        }

    }

}
