package id.kosasih.eduaction.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF1B5E20),     // Hijau tua
    onPrimary = Color.White,
    secondary = Color(0xFF0288D1),   // Biru untuk air
    onSecondary = Color.White,
    tertiary = Color(0xFF689F38),    // Hijau muda
    onTertiary = Color.White,
    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF212121),
    surface = Color.White,
    onSurface = Color(0xFF212121)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF4CAF50),     // Hijau
    onPrimary = Color.Black,
    secondary = Color(0xFF03A9F4),   // Biru untuk air
    onSecondary = Color.Black,
    tertiary = Color(0xFF8BC34A),    // Hijau muda
    onTertiary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF212121),
    onSurface = Color.White
)

@Composable
fun EduActionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}