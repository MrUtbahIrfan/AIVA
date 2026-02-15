package com.utbah.aiva.ui.speech

import android.content.Context
import android.speech.tts.TextToSpeech

class TTSManager(context: Context) {
    private val tts = TextToSpeech(context) {}

    fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}
