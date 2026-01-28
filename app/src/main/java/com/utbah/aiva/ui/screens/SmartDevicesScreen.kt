package com.utbah.aiva.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

data class SmartRoom(
    val name: String,
    val icon: ImageVector,
    val status: String,
    val gradient: List<Color>
)

@Composable
fun SmartDevicesScreen(navController: NavController) {
    val rooms = listOf(
        SmartRoom(
            name = "Living Room",
            icon = Icons.Default.Lightbulb,
            status = "3 devices on",
            gradient = listOf(Color(0xFFEAB308), Color(0xFFF59E0B))
        ),
        SmartRoom(
            name = "Bedroom",
            icon = Icons.Default.Bed,
            status = "72°F",
            gradient = listOf(Color(0xFFEA580C), Color(0xFFDC2626))
        ),
        SmartRoom(
            name = "Kitchen",
            icon = Icons.Default.Coffee,
            status = "1 device on",
            gradient = listOf(Color(0xFFF59E0B), Color(0xFFEA580C))
        ),
        SmartRoom(
            name = "Security",
            icon = Icons.Default.Lock,
            status = "Armed",
            gradient = listOf(Color(0xFF10B981), Color(0xFF059669))
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = "devices",
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
                text = "Smart Devices",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(rooms) { room ->
                    SmartRoomCard(room)
                }
            }
        }
    }
}

@Composable
fun SmartRoomCard(room: SmartRoom) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Brush.linearGradient(room.gradient)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = room.icon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Column {
                    Text(
                        text = room.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = room.status,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}