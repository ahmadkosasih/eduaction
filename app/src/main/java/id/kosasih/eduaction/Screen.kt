package id.kosasih.eduaction

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Beranda", Icons.Filled.Home)
    object Lingkunganku : Screen("lingkunganku", "Lingkungan", Icons.Filled.Info)
    object PeduliBerbagi : Screen("peduli_berbagi", "Peduli", Icons.Filled.Share)
    object AksiNyata : Screen("aksi_nyata", "Aksi Nyata", Icons.Filled.BarChart)
}