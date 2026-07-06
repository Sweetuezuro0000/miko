package com.miko.app.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionManager {

    private const val REQUEST_CODE = 100

    private val permissions = arrayOf(

        Manifest.permission.RECORD_AUDIO,

        Manifest.permission.POST_NOTIFICATIONS

    )

    fun hasPermissions(

        context: Context

    ): Boolean {

        return permissions.all {

            ContextCompat.checkSelfPermission(

                context,

                it

            ) == PackageManager.PERMISSION_GRANTED

        }

    }

    fun request(

        activity: Activity

    ) {

        ActivityCompat.requestPermissions(

            activity,

            permissions,

            REQUEST_CODE

        )

    }

}
