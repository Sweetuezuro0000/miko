package com.miko.app.backup

import android.content.Context
import java.io.File

class BackupManager(

    private val context: Context

) {

    fun backup(): Boolean {

        return try {

            val folder = File(

                context.filesDir,

                "backup"

            )

            if (!folder.exists()) {

                folder.mkdirs()

            }

            true

        } catch (e: Exception) {

            false

        }

    }

}
