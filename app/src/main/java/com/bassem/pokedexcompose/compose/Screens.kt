package com.bassem.pokedexcompose.compose

import androidx.navigation.NamedNavArgument

sealed class Screens(val route: String, val navArguments: List<NamedNavArgument> = emptyList()) {

    data object Home : Screens("home")
    data object Splash : Screens("splash")
}