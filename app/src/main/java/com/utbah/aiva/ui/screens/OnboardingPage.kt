package com.utbah.aiva.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class OnboardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val gradient: List<Color>
)

@Composable
fun OnboardingScreen(
    onGetStarted: () -> Unit
) {
    var currentPage by remember { mutableStateOf(0) }

    val pages = listOf(
        OnboardingPage(
            title = "Welcome to AIVA",
            description = "Your intelligent voice assistant that learns and adapts to you",
            icon = Icons.Default.Bolt,
            gradient = listOf(Color(0xFF3B82F6), Color(0xFF8B5CF6))
        ),
        OnboardingPage(
            title = "Voice Control",
            description = "Simply tap and speak. AIVA understands natural conversation",
            icon = Icons.Default.Mic,
            gradient = listOf(Color(0xFF22D3EE), Color(0xFF3B82F6))
        ),
        OnboardingPage(
            title = "Privacy First",
            description = "Your conversations are encrypted and processed securely",
            icon = Icons.Default.Shield,
            gradient = listOf(Color(0xFF8B5CF6), Color(0xFFA855F7))
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // Icon
        Box(
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .background(Brush.linearGradient(pages[currentPage].gradient))
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = pages[currentPage].icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(64.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Title
        Text(
            text = pages[currentPage].title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.animateContentSize()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = pages[currentPage].description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .animateContentSize()
        )

        Spacer(modifier = Modifier.weight(1f))

        // Page Indicators
        Row(
            modifier = Modifier.padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            pages.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(if (index == currentPage) 32.dp else 6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(
                            if (index == currentPage) {
                                Brush.linearGradient(pages[currentPage].gradient)
                            } else {
                                Brush.linearGradient(
                                    listOf(
                                        MaterialTheme.colorScheme.surfaceVariant,
                                        MaterialTheme.colorScheme.surfaceVariant
                                    )
                                )
                            }
                        )
                        .animateContentSize()
                )
            }
        }

        // Continue Button
        Button(
            onClick = {
                if (currentPage < pages.size - 1) {
                    currentPage++
                } else {
                    onGetStarted()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = if (currentPage < pages.size - 1) "Continue" else "Get Started",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}