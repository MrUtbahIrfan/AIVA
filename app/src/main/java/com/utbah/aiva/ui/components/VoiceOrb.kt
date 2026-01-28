package com.utbah.aiva.ui.components


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

enum class VoiceState {
    IDLE, LISTENING, PROCESSING, SPEAKING
}

@Composable
fun VoiceOrb(
    voiceState: VoiceState,
    onTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "orb")

    // Scale animation
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = when (voiceState) {
            VoiceState.LISTENING -> 1.1f
            VoiceState.PROCESSING -> 1.05f
            else -> 1f
        },
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    // Rotation for processing state
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    // Ring expansion animations
    val ring1Alpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring1"
    )

    val ring2Alpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring2"
    )

    val ring3Alpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(2100, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring3"
    )

    val ring1Scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring1Scale"
    )

    val ring2Scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring2Scale"
    )

    val ring3Scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(2100, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ring3Scale"
    )

    // Colors based on state
    val gradientColors = when (voiceState) {
        VoiceState.LISTENING -> listOf(
            Color(0xFF60A5FA),
            Color(0xFF22D3EE),
            Color(0xFF14B8A6)
        )
        VoiceState.PROCESSING -> listOf(
            Color(0xFFA78BFA),
            Color(0xFFC084FC),
            Color(0xFFEC4899)
        )
        VoiceState.SPEAKING -> listOf(
            Color(0xFF22D3EE),
            Color(0xFF60A5FA),
            Color(0xFF818CF8)
        )
        else -> listOf(
            Color(0xFF3B82F6),
            Color(0xFF8B5CF6)
        )
    }

    Box(
        modifier = modifier
            .size(240.dp),
        contentAlignment = Alignment.Center
    ) {
        // Expanding rings for listening and speaking states
        if (voiceState == VoiceState.LISTENING || voiceState == VoiceState.SPEAKING) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val center = Offset(size.width / 2, size.height / 2)
                val baseRadius = size.minDimension / 2

                // Ring 1
                drawCircle(
                    color = gradientColors[0].copy(alpha = ring1Alpha * 0.3f),
                    radius = baseRadius * ring1Scale,
                    center = center,
                    style = Stroke(width = 2.dp.toPx())
                )

                // Ring 2
                drawCircle(
                    color = gradientColors[0].copy(alpha = ring2Alpha * 0.3f),
                    radius = baseRadius * ring2Scale,
                    center = center,
                    style = Stroke(width = 2.dp.toPx())
                )

                // Ring 3
                if (voiceState == VoiceState.SPEAKING) {
                    drawCircle(
                        color = gradientColors[0].copy(alpha = ring3Alpha * 0.3f),
                        radius = baseRadius * ring3Scale,
                        center = center,
                        style = Stroke(width = 2.dp.toPx())
                    )
                }
            }
        }

        // Main orb
        Box(
            modifier = Modifier
                .size(192.dp)
                .scale(if (voiceState == VoiceState.IDLE) 1f else scale)
                .shadow(
                    elevation = 24.dp,
                    shape = CircleShape,
                    ambientColor = gradientColors[0].copy(alpha = 0.5f),
                    spotColor = gradientColors[0].copy(alpha = 0.5f)
                )
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = gradientColors
                    )
                )
                .clickable(
                    onClick = onTap,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Voice",
                modifier = Modifier.size(72.dp),
                tint = Color.White
            )

            // Waveform bars for listening state
            if (voiceState == VoiceState.LISTENING) {
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 40.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    repeat(5) { index ->
                        WaveformBar(delay = index * 100)
                    }
                }
            }
        }
    }
}

@Composable
fun WaveformBar(delay: Int) {
    val infiniteTransition = rememberInfiniteTransition(label = "waveform")

    val height by infiniteTransition.animateFloat(
        initialValue = 8f,
        targetValue = 24f,
        animationSpec = infiniteRepeatable(
            animation = tween(400, easing = FastOutSlowInEasing, delayMillis = delay),
            repeatMode = RepeatMode.Reverse
        ),
        label = "height"
    )

    Box(
        modifier = Modifier
            .width(3.dp)
            .height(height.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.White)
    )
}