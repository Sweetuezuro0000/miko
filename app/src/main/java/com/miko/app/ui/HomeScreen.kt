package com.miko.app.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miko.app.ai.Command
import com.miko.app.ai.CommandParser
import com.miko.app.ai.ReplyEngine
import com.miko.app.voice.SpeechRecognizerManager
import com.miko.app.voice.VoiceManager

@Composable
fun HomeScreen(

    context: Context

) {

    var status by remember {

        mutableStateOf("🟢 Ready")

    }

    val voice = remember {

        VoiceManager(context)

    }

    val speech = remember {

        SpeechRecognizerManager(context) { text ->

            if (!text.lowercase().contains("miko"))
                return@SpeechRecognizerManager

            voice.speak(ReplyEngine.listening())

            status = text

            when (CommandParser.parse(text)) {

                Command.NOTE -> {

                    voice.speak(ReplyEngine.working())

                    status = "📝 Creating Note"

                    voice.speak(ReplyEngine.success())

                }

                Command.DOCUMENT -> {

                    voice.speak(ReplyEngine.working())

                    status = "📂 Opening Documents"

                    voice.speak(ReplyEngine.success())

                }

                Command.REMINDER -> {

                    voice.speak(ReplyEngine.working())

                    status = "🔔 Reminder"

                    voice.speak(ReplyEngine.success())

                }

                else -> {

                    voice.speak(ReplyEngine.error())

                }

            }

        }

    }

    LaunchedEffect(Unit) {

        speech.start()

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(

            text = "MIKO",

            style = MaterialTheme.typography.headlineLarge

        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(status)

    }

}
