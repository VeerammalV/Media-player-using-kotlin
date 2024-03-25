package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MyService : Service() {

    private var player : MediaPlayer? = null

    override fun onStartCommand(init:Intent, flag:Int , startId:Int):Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player?.setLooping(true)
        player?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (player != null) {
            player?.stop()
        }

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}