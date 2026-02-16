package com.utbah.aiva.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.utbah.aiva.ui.components.BottomNavigationBar
import com.utbah.aiva.ui.components.VoiceOrb
import com.utbah.aiva.ui.components.VoiceState
import com.utbah.aiva.ui.speech.VoiceManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class SuggestionCard(
    val icon: ImageVector,
    val text: String,
    val gradient: List<Color>
)

@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    navController: NavController
) {

    val context = LocalContext.current
    val voiceManager = remember { VoiceManager(context) }
    var voiceState by remember { mutableStateOf(VoiceState.IDLE) }
    var spokenText by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val suggestions = listOf(
        SuggestionCard(
            Icons.Default.CalendarToday,
            "Today's schedule",
            listOf(Color(0xFF3B82F6), Color(0xFF22D3EE))
        ),
        SuggestionCard(
            Icons.Default.Coffee,
            "Morning routine",
            listOf(Color(0xFFF59E0B), Color(0xFFEA580C))
        ),
        SuggestionCard(
            Icons.Default.Lightbulb,
            "Smart home",
            listOf(Color(0xFFEAB308), Color(0xFFF59E0B))
        ),
        SuggestionCard(
            Icons.Default.Message,
            "Messages",
            listOf(Color(0xFF8B5CF6), Color(0xFFA855F7))
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar (
                selectedItem = "home",
                onItemSelected = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "AIVA",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Your AI Voice Assistant",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onThemeToggle,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    Icon(
                        imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle theme"
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Voice Orb
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    VoiceOrb(
                        voiceState = voiceState,
                        onTap = {
                            if (voiceState == VoiceState.IDLE) {
                                scope.launch {
                                    voiceState = VoiceState.LISTENING
                                    delay(2000)
                                    voiceState = VoiceState.PROCESSING
                                    delay(1500)
                                    voiceState = VoiceState.SPEAKING
                                    delay(2000)
                                    voiceState = VoiceState.IDLE
                                }
                            }
                        }
                    )

                    VoiceOrb(
                        voiceState = voiceState,
                        onTap = {
                            voiceManager.startListening(
                                callback = { spokenText = it },
                                onState = { voiceState = it }
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = when (voiceState) {
                            VoiceState.IDLE -> "Tap to speak"
                            VoiceState.LISTENING -> "Listening..."
                            VoiceState.PROCESSING -> "Processing..."
                            VoiceState.SPEAKING -> "Responding..."
                        },
                        style = MaterialTheme.typography.titleLarge,
                        color = if (voiceState != VoiceState.IDLE) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        }
                    )

                    Text(
                        text = "Try: \"What's on my calendar today?\"",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            // Suggestions
            Column(
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = "SUGGESTIONS",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.height(180.dp)
                ) {
                    items(suggestions) { suggestion ->
                        SuggestionCardItem(suggestion)
                    }
                }
            }
        }
    }
}

@Composable
fun SuggestionCardItem(suggestion: SuggestionCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Brush.linearGradient(suggestion.gradient)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = suggestion.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = suggestion.text,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }
    }
}