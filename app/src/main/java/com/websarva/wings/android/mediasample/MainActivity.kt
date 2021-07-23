package com.websarva.wings.android.mediasample

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var _player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _player = MediaPlayer()
        val mediaFileUriStr = "android.resource://${packageName}/${R.raw.mountain_stream}"
        val mediaFFileUri = Uri.parse(mediaFileUriStr)
        _player?.let{
            it.setDataSource(this@MainActivity,mediaFileUri)
            it.setOnPreparedListener(PlayerPreparedListener())
            it.setOnCompletionLister(playerCompletionLitener())
            it.prepareAsync()
        }
    }
}