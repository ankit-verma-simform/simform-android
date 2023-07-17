package com.example.androiddemoproject.permissions.runtimepermissions.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AlertDialog

fun Context.showGrantPermissionFromSettingsDialog(
    title: String,
    message: String,
) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setTitle(title)
        .setMessage(message)
        .setPositiveButton("Goto Settings") { _, _ ->
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", packageName, null)
            ).also(::startActivity)
        }
    builder.create().show()
}

fun Context.showRationaleDialog(
    title: String,
    message: String,
    permission: String,
    handlePermission: (String) -> Unit
) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setTitle(title)
        .setMessage(message)
        .setPositiveButton("Ok") { _, _ ->
            handlePermission(permission)
        }
    builder.create().show()
}
