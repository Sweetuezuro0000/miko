package com.miko.app.reminder

class ReminderRepository {

    private val reminders = mutableListOf<Reminder>()

    fun add(reminder: Reminder) {

        reminders.add(reminder)

    }

    fun getAll(): List<Reminder> {

        return reminders

    }

    fun delete(index: Int) {

        if (index in reminders.indices) {

            reminders.removeAt(index)

        }

    }

}
