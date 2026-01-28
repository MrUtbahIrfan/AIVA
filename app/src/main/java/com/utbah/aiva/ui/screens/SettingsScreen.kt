package com.utbah.aiva.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.utbah.aiva.ui.components.BottomNavigationBar

data class SettingItem(
    val icon: ImageVector,
    val label: String,
    val description: String,
    val gradient: List<Color>
)

@Composable
fun SettingsScreen(navController: NavController) {
    val privacySettings = listOf(
        SettingItem(
            icon = Icons.Default.Shield,
            label = "Voice Data Storage",
            description = "Stored locally on device",
            gradient = listOf(Color(0xFF3B82F6), Color(0xFF8B5CF6))
        ),
        SettingItem(
            icon = Icons.Default.Lock,
            label = "Encryption",
            description = "End-to-end encrypted",
            gradient = listOf(Color(0xFF8B5CF6), Color(0xFFA855F7))
        ),
        SettingItem(
            icon = Icons.Default.Delete,
            label = "Clear History",
            description = "Delete all conversations",
            gradient = listOf(Color(0xFFEF4444), Color(0xFFDC2626))
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = "settings",
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
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )

            // Privacy Section
            Text(
                text = "PRIVACY & SECURITY",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column {
                    privacySettings.forEachIndexed { index, setting ->
                        SettingItemRow(
                            setting = setting,
                            showDivider = index < privacySettings.size - 1
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Preferences Section
            Text(
                text = "PREFERENCES",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column {
                    PreferenceRow("Wake Word", "\"Hey AIVA\"", true)
                    PreferenceRow("Voice Gender", "Female", true)
                    PreferenceRow("Language", "English (US)", false)
                }
            }
        }
    }
}

@Composable
fun SettingItemRow(setting: SettingItem, showDivider: Boolean) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Brush.linearGradient(setting.gradient)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = setting.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = setting.label,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = setting.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}

@Composable
fun PreferenceRow(label: String, value: String, showDivider: Boolean) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}