package com.example.androiddemoproject.permissions

import android.app.Activity
import com.example.androiddemoproject.permissions.camera.CameraDemoActivity
import com.example.androiddemoproject.permissions.runtimepermissions.RuntimePermissionsActivity

data class PermissionsMainNavigation(
    val activity: Class<out Activity>,
    val label: String
)

fun getPermissionsMainNavigation() = listOf(
    PermissionsMainNavigation(
        RuntimePermissionsActivity::class.java,
        "Runtime Permissions"
    ),
    PermissionsMainNavigation(
        CameraDemoActivity::class.java,
        "Take photo from Camera"
    ),
)
