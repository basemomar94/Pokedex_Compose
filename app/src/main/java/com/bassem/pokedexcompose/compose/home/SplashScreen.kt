package com.bassem.pokedexcompose.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bassem.pokedexcompose.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.delay

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SplashScreen(onTime: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        onTime()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(model = R.drawable.pokemon_animation, contentDescription = "pokemon animation")
    }

}