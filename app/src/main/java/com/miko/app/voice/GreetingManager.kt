package com.miko.app.voice

import java.util.Calendar

object GreetingManager {

    fun greeting(): String {

        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        return when {

            hour in 5..11 ->
                "Good Morning ji."

            hour in 12..16 ->
                "Good Afternoon ji."

            hour in 17..20 ->
                "Good Evening ji."

            else ->
                "Good Night ji."

        }

    }

}
