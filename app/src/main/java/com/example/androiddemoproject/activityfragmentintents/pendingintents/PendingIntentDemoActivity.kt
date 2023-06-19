package com.example.androiddemoproject.activityfragmentintents.pendingintents

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityPendingIntentDemoBinding

class PendingIntentDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPendingIntentDemoBinding

    companion object {
        const val NOTIFICATION_ID = 1001
        const val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
        const val PENDING_INTENT_REQUEST_CODE = 1010
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pending_intent_demo)
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        setupBtnSendNotificationClickListener()
        setupBtnCancelNotificationClickListener()
        setupBtnSendPendingIntentClickListener()
        setupBtnCancelPendingIntentClickListener()
    }

    private fun getPendingIntentForDestinationActivity(): PendingIntent? = PendingIntent.getActivity(
        this,
        PENDING_INTENT_REQUEST_CODE,
        Intent(this, PendingIntentDestinationActivity::class.java),
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    private fun setupBtnSendNotificationClickListener() {
        binding.btnNotificationIntent.setOnClickListener {
            val pendingIntent = getPendingIntentForDestinationActivity()
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // create notification channel if API level 26+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "Pending Intents Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description =
                        "These notifications are to explore notification service with pending intents"
                    enableLights(true)
                    lightColor = Color.RED
                    vibrationPattern = longArrayOf(0, 1000, 500, 1000)
                    enableVibration(true)
                }
                notificationManager.createNotificationChannel(notificationChannel)
            }

            val notificationBuilder = NotificationCompat.Builder(
                this,
                NOTIFICATION_CHANNEL_ID
            )
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.target)
                .setTicker("AndroidDemos")
                .setContentTitle("Pending Intents Notification")
                .setContentText("Click here to open Pending Intent Destination Activity")
                .setContentInfo("Notification to explore pending intents and its behaviour")
                .setContentIntent(pendingIntent)

            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }

    private fun setupBtnCancelNotificationClickListener() {
        binding.btnCancelNotificationIntent.setOnClickListener {
            val notificationManager =
                applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancel(NOTIFICATION_ID)
        }
    }

    private fun setupBtnSendPendingIntentClickListener() {
        binding.btnSendPendingIntent.setOnClickListener {
            val pendingIntent = getPendingIntentForDestinationActivity()
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (5_000),
                pendingIntent
            )
        }
    }

    private fun setupBtnCancelPendingIntentClickListener() {
        binding.btnCancelPendingIntent.setOnClickListener {
            val pendingIntent = getPendingIntentForDestinationActivity()
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
        }
    }
}
