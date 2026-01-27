package com.utbah.aiva.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Theme Colors
private val LightPrimary = Color(0xFF3B82F6)
private val LightOnPrimary = Color(0xFFFFFFFF)
private val LightPrimaryContainer = Color(0xFFDCE7FF)
private val LightOnPrimaryContainer = Color(0xFF001849)

private val LightSecondary = Color(0xFF8B5CF6)
private val LightOnSecondary = Color(0xFFFFFFFF)
private val LightSecondaryContainer = Color(0xFFEBDDFF)
private val LightOnSecondaryContainer = Color(0xFF2B0051)

private val LightTertiary = Color(0xFF06B6D4)
private val LightOnTertiary = Color(0xFFFFFFFF)
private val LightTertiaryContainer = Color(0xFFCFF7FF)
private val LightOnTertiaryContainer = Color(0xFF002022)

private val LightError = Color(0xFFEF4444)
private val LightOnError = Color(0xFFFFFFFF)
private val LightErrorContainer = Color(0xFFFFDAD6)
private val LightOnErrorContainer = Color(0xFF410002)

private val LightBackground = Color(0xFFF9FAFB)
private val LightOnBackground = Color(0xFF111827)
private val LightSurface = Color(0xFFFFFFFF)
private val LightOnSurface = Color(0xFF111827)
private val LightSurfaceVariant = Color(0xFFF3F4F6)
private val LightOnSurfaceVariant = Color(0xFF6B7280)

private val LightOutline = Color(0xFFE5E7EB)
private val LightOutlineVariant = Color(0xFFF3F4F6)

// Dark Theme Colors
private val DarkPrimary = Color(0xFF60A5FA)
private val DarkOnPrimary = Color(0xFF001849)
private val DarkPrimaryContainer = Color(0xFF1E3A8A)
private val DarkOnPrimaryContainer = Color(0xFFDCE7FF)

private val DarkSecondary = Color(0xFFA78BFA)
private val DarkOnSecondary = Color(0xFF2B0051)
private val DarkSecondaryContainer = Color(0xFF5B21B6)
private val DarkOnSecondaryContainer = Color(0xFFEBDDFF)

private val DarkTertiary = Color(0xFF22D3EE)
private val DarkOnTertiary = Color(0xFF002022)
private val DarkTertiaryContainer = Color(0xFF0E7490)
private val DarkOnTertiaryContainer = Color(0xFFCFF7FF)

private val DarkError = Color(0xFFFF5449)
private val DarkOnError = Color(0xFF410002)
private val DarkErrorContainer = Color(0xFF7F1D1D)
private val DarkOnErrorContainer = Color(0xFFFFDAD6)

private val DarkBackground = Color(0xFF030712)
private val DarkOnBackground = Color(0xFFF9FAFB)
private val DarkSurface = Color(0xFF111827)
private val DarkOnSurface = Color(0xFFF9FAFB)
private val DarkSurfaceVariant = Color(0xFF1F2937)
private val DarkOnSurfaceVariant = Color(0xFF9CA3AF)

private val DarkOutline = Color(0xFF374151)
private val DarkOutlineVariant = Color(0xFF1F2937)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    outlineVariant = LightOutlineVariant
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant
)

@Composable
fun AIVATheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}



//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)
//
//@Composable
//fun AIVATheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}

