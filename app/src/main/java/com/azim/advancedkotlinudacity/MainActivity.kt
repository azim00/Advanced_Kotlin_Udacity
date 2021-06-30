package com.azim.advancedkotlinudacity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createChannel(
            channelId = resources.getString(R.string.notificationChannel1),
            channelName = resources.getString(R.string.notificationChannelHumanName1),
            channelDescription = resources.getString(R.string.notificationChannelDescription1)
        )

        ContextCompat.getSystemService(applicationContext, NotificationManager::class.java)
            ?.setNotification(
                applicationContext = this,
                title = "Hello World",
                messageBody = "Simple Text message that will be seen from the app"
            )
    }

    private fun createChannel(channelId: String, channelName: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId, //System Name for the app/developer
                channelName, // Human Readable Name this is shown in the settings if you click on the notification
                NotificationManager.IMPORTANCE_LOW // Priority of the Notification
            )

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.YELLOW
            notificationChannel.enableVibration(true)
            notificationChannel.description = channelDescription // Shown on the bottom of the page


            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            /*
            //NOTE: This will allow to remove all old notification channel helps to keep Notification Clean
            notificationManager.notificationChannels.onEach {
                notificationManager.deleteNotificationChannel(it.id)
            }*/
            notificationManager.createNotificationChannel(notificationChannel)

        }
    }
}