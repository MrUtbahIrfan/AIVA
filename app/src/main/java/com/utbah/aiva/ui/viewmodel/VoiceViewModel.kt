package com.utbah.aiva.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utbah.aiva.ui.components.VoiceState
import com.utbah.aiva.ui.speech.TTSManager
import com.utbah.aiva.ui.speech.VoiceManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class VoiceViewModel(
    private val speechManager: VoiceManager,
    private val tts: TTSManager,
    private val aiService: AIService
) : ViewModel() {

    val voiceState = MutableStateFlow(VoiceState.IDLE)
    val transcript = MutableStateFlow("")
    val amplitude = MutableStateFlow(0f)

    fun startVoice() {
        speechManager.startListening(
            onText = { transcript.value = it; processAI(it) },
            onState = { voiceState.value = it },
            onRms = { amplitude.value = it }
        )
    }

    private fun processAI(text: String) {
        viewModelScope.launch {
            voiceState.value = VoiceState.PROCESSING
            val response = aiService.ask(text)
            voiceState.value = VoiceState.SPEAKING
            tts.speak(response)
            delay(2000)
            voiceState.value = VoiceState.IDLE
        }
    }
}
