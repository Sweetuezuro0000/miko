package com.miko.app.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miko.app.ai.Assistant
import com.miko.app.ai.Command
import com.miko.app.ai.ReplyEngine
import com.miko.app.data.AppSettings
import com.miko.app.voice.SpeechRecognizerManager
import com.miko.app.voice.VoiceManager
import com.miko.app.utils.FlashlightManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    context: Context
) {

    var status by remember {

        mutableStateOf("🟢 Ready")

    }

    var waitingCommand by remember {

        mutableStateOf(false)

    }

    val voice = remember {

        VoiceManager(context)

    }
    val flashlight = remember {
    FlashlightManager(context)
    }

    val speech = remember {

        SpeechRecognizerManager(context) { result ->

            val text = result.lowercase()

            status = result

            if (!AppSettings.voiceEnabled)
                return@SpeechRecognizerManager

            if (!waitingCommand) {

                if (
                    text == "miko" ||
                    text == "hey miko" ||
                    text == "hello miko"
                ) {

                    waitingCommand = true

                    val reply = ReplyEngine.listening()

                    status = reply

                    if (AppSettings.speakReply)
                        voice.speak(reply)

                }

                return@SpeechRecognizerManager

            }

            val response = Assistant.process(result)

            status = response.reply

            if (AppSettings.speakReply)
                voice.speak(response.reply)

            when (response.action) {

                Command.NOTE -> {

                    status = "📝 Note Ban Gaya"

                    voice.speak(ReplyEngine.success())

                }

                Command.DOCUMENT -> {

                    status = "📂 Documents Open"

                    voice.speak(ReplyEngine.success())

                }

                Command.REMINDER -> {

                    status = "🔔 Reminder Saved"

                    voice.speak(ReplyEngine.success())

                }

                Command.SETTINGS -> {

                    status = "⚙️ Settings"

                    voice.speak(ReplyEngine.success())

                }

                Command.SEARCH -> {

                    status = "🔍 Searching"

                    voice.speak(ReplyEngine.success())

                }
                Command.FLASHLIGHT_ON -> {

    flashlight.on()

    status = "🔦 Flashlight ON"

    voice.speak("Flashlight on kar di.")
}

Command.FLASHLIGHT_OFF -> {

    flashlight.off()

    status = "🔦 Flashlight OFF"

    voice.speak("Flashlight off kar di.")
}

Command.TIME -> {

    val time = SimpleDateFormat("hh:mm a", Locale.getDefault())
        .format(Date())

    status = "🕒 $time"

    voice.speak("Abhi time hai $time")
}

                else -> {

                    voice.speak(ReplyEngine.error())

                }

            }

            waitingCommand = false

        }

    }

    LaunchedEffect(Unit) {
    status = "Starting speech..."
        speech.start()

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {

        Text(

            text = "MIKO",

            style = MaterialTheme.typography.headlineLarge

        )

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(status)

            }

        }

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

    }

}
