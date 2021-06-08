package com.example.myapplication


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.myapplication.database.DatabaseHandler
import java.util.*


class ReminderService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var tts: TextToSpeech? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("ReminderService", "onCreate called")
        // enable to play a custom ring tone
        /*mediaPlayer = MediaPlayer.create(this, R.raw.alarm_ringtone)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()*/
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d("ReminderService", "onBind called")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ReminderService", "onStartCommand called")
        val reminderId = intent?.getLongExtra("reminderId", 0)
        val databaseHandler = DatabaseHandler(this)
        val reminder = databaseHandler.getReminderById(reminderId ?: 0)
        showAlarmNotification(reminder)

        val speakText = reminder.title + " " + reminder.description
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
                if (it != TextToSpeech.ERROR) {
                    tts?.language = Locale.US
                    tts?.speak(speakText, TextToSpeech.QUEUE_ADD, null, null)
                } else {
                    Log.d("ReminderService", "Error: $it")
                }
            })
        Log.d("ReminderService", speakText)
        return START_STICKY
    }

    private fun showAlarmNotification(reminder: Reminder) {
        Log.d("ReminderService", "showAlarmNotification called")

        createNotificationChannel(reminder.id.toInt())
        // build notification
        val builder = NotificationCompat.Builder(this, reminder.id.toString())

            .setContentTitle(reminder.title) //set title of notification
            .setContentText(reminder.description)//this is notification message
            .setAutoCancel(true) // makes auto cancel of notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //set priority of notification

        val notificationIntent = Intent(applicationContext, MainActivityR2::class.java)
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //notification message will get at NotificationView
        notificationIntent.putExtra("reminderId", reminder.id)
        notificationIntent.putExtra("from", "Notification")

        val pendingIntent = PendingIntent.getActivity(
            applicationContext, 0, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        builder.setContentIntent(pendingIntent)
        val notification = builder.build()

        // Add as notification
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(reminder.id.toInt(), notification)
    }

    private fun createNotificationChannel(id: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                id.toString(),
                "Reminder Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }

    override fun onDestroy() {
        Log.d("ReminderService", "onDestroy called")
        super.onDestroy()

        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }

        tts?.stop()
        tts?.shutdown()
    }

}
