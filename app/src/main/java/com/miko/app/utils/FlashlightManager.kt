package com.miko.app.utils

import android.content.Context
import android.hardware.camera2.CameraManager

class FlashlightManager(context: Context) {

    private val cameraManager =
        context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    private val cameraId = cameraManager.cameraIdList.firstOrNull()

    fun on() {
        cameraId?.let {
            cameraManager.setTorchMode(it, true)
        }
    }

    fun off() {
        cameraId?.let {
            cameraManager.setTorchMode(it, false)
        }
    }
}
