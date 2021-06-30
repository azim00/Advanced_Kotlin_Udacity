package com.azim.advancedkotlinudacity

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

fun NotificationManager.setNotification(
    messageBody: String,
    title: String,
    applicationContext: Context
) {


    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.notificationChannel1) //Mandatory from later stage of the Android 26
    )
        .setContentTitle(title)
        .setContentText(messageBody)
        .setSmallIcon(R.drawable.ic_egg_svgrepo_com)


    notify(
        applicationContext.resources.getInteger(R.integer.channelNotificationID1),
        builder.build()
    )
}