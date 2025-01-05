package com.example.motivacniaplikace

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.content.pm.PackageManager
import android.app.Activity
import androidx.core.app.ActivityCompat

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    companion object {
        const val PERMISSION_REQUEST_CODE = 1001

        // Metoda pro kontrolu a žádost o oprávnění pro notifikace
        fun checkAndRequestNotificationPermission(activity: Activity): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val permission = "android.permission.POST_NOTIFICATIONS"
                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, arrayOf(permission), PERMISSION_REQUEST_CODE)
                    false
                } else {
                    true
                }
            } else {
                true
            }
        }
    }

    // Metoda doWork je volána při spuštění WorkManager úlohy
    override fun doWork(): Result {
        // Zobrazíme notifikaci
        showDailyQuoteNotification()

        return Result.success()
    }

    // Metoda pro zobrazení denní notifikace
    private fun showDailyQuoteNotification() {
        val channelId = "daily_quote_channel"
        val notificationId = 1

        // Vytvoření notification channel pro Android 8.0 a vyšší
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Citát dne", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Notifikace s informací o novém citátu dne"
            }
            val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Zkontrolování oprávnění pro notifikace
        if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.POST_NOTIFICATIONS") == PackageManager.PERMISSION_GRANTED) {
            // Vytvoření notifikace
            val notification = NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Nový citát dne je zde!")
                .setContentText("Otevřete aplikaci a inspirujte se novým citátem dne.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()

            // Zobrazení notifikace
            val notificationManager = NotificationManagerCompat.from(applicationContext)
            notificationManager.notify(notificationId, notification)
        }
    }
}
