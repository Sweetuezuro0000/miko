package com.miko.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.miko.app.ui.HomeScreen
import com.miko.app.utils.PermissionManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Runtime permissions
        if (!PermissionManager.hasPermissions(this)) {
            PermissionManager.request(this)
        }

        setContent {
            HomeScreen(this)
        }
    }
}
