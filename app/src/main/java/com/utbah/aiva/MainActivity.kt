package com.utbah.aiva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.utbah.aiva.ui.screens.HomeScreen
import com.utbah.aiva.ui.screens.OnboardingScreen
import com.utbah.aiva.ui.theme.AIVATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIVAApp()
        }
    }
}

@Composable
fun AIVAApp() {
    var isDarkTheme by remember { mutableStateOf(true) }
    val navController = rememberNavController()

    AIVATheme(darkTheme = isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = "onboarding"
            ) {
                composable("onboarding") {
                    OnboardingScreen(
                        onGetStarted = {
                            navController.navigate("home") {
                                popUpTo("onboarding") { inclusive = true }
                            }
                        }
                    )
                }
                composable("home") {
                    HomeScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = { isDarkTheme = !isDarkTheme },
                        navController = navController
                    )
                }
//                composable("devices") {
//                    SmartDevicesScreen(navController = navController)
//                }
//                composable("history") {
//                    HistoryScreen(navController = navController)
//                }
//                composable("settings") {
//                    SettingsScreen(navController = navController)
//                }
            }
        }
    }
}