package id.kosasih.eduaction

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.kosasih.eduaction.ui.screens.AksiNyataScreen
import id.kosasih.eduaction.ui.screens.HomeScreen
import id.kosasih.eduaction.ui.screens.LingkungankuScreen
import id.kosasih.eduaction.ui.screens.PeduliBerbagiScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EduActionApp() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.Home,
        Screen.Lingkunganku,
        Screen.PeduliBerbagi,
        Screen.AksiNyata
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "EduAction",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Lingkunganku.route) { LingkungankuScreen() }
            composable(Screen.PeduliBerbagi.route) { PeduliBerbagiScreen() }
            composable(Screen.AksiNyata.route) { AksiNyataScreen() }
        }
    }
}