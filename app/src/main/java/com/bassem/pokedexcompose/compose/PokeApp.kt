package com.bassem.pokedexcompose.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bassem.pokedexcompose.compose.home.HomeScreen
import com.bassem.pokedexcompose.compose.home.SplashScreen

@Composable
fun PokeApp() {
    val navController = rememberNavController()
    PokeNavHost(navController)
}

@Composable
fun PokeNavHost(navController: NavHostController) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Home.route) {
            HomeScreen()
        }
        composable(route = Screens.Splash.route) {
            SplashScreen {
                navController.navigate(Screens.Home.route) {
                    popUpTo(Screens.Splash.route) { inclusive = true }
                }


            }
        }
    }


}