package com.utbah.aiva.ui.speech

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import com.utbah.aiva.ui.components.VoiceState
import java.util.Locale

class VoiceManager(private val context: Context) {

    private val recognizer = SpeechRecognizer.createSpeechRecognizer(context)
    private val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
    }

//    fun startListening(callback: (String) -> Unit, onState: (VoiceState) -> Unit) {
//        recognizer.setRecognitionListener(object : RecognitionListener {
//            override fun onReadyForSpeech(params: Bundle?) {
//                onState(VoiceState.LISTENING)
//            }
//
//            override fun onEndOfSpeech() {
//                onState(VoiceState.PROCESSING)
//            }
//
//            override fun onResults(results: Bundle?) {
//                val text = results
//                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
//                    ?.firstOrNull() ?: ""
//                callback(text)
//                onState(VoiceState.SPEAKING)
//            }
//
//            override fun onError(error: Int) {
//                onState(VoiceState.IDLE)
//            }
//
//            override fun onRmsChanged(rmsdB: Float) {}
//            override fun onPartialResults(partialResults: Bundle?) {}
//            override fun onBeginningOfSpeech() {}
//            override fun onBufferReceived(buffer: ByteArray?) {}
//            override fun onEvent(eventType: Int, params: Bundle?) {}
//        })
//
//        recognizer.startListening(intent)
//    }

    fun startListening(
        onText: (String) -> Unit,
        onState: (VoiceState) -> Unit,
        onRms: (Float) -> Unit
    ) {
        recognizer.setRecognitionListener(object : RecognitionListener {

            override fun onReadyForSpeech(params: Bundle?) {
                onState(VoiceState.LISTENING)
            }

            override fun onEndOfSpeech() {
                onState(VoiceState.PROCESSING)
            }

            override fun onResults(results: Bundle?) {
                val text = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull() ?: ""
                onText(text)
                onState(VoiceState.SPEAKING)
            }

            override fun onRmsChanged(rmsdB: Float) {
                onRms(rmsdB)
            }

            override fun onError(error: Int) {
                onState(VoiceState.IDLE)
            }

            override fun onPartialResults(bundle: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })

        recognizer.startListening(intent)
    }
}
