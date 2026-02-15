package com.utbah.aiva.ui.viewmodel

interface AIService {
    suspend fun ask(prompt: String): String
}