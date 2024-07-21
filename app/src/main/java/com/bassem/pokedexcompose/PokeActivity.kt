package com.bassem.pokedexcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.pokedexcompose.compose.PokeApp
import com.bassem.pokedexcompose.compose.home.HomeScreen
import com.bassem.pokedexcompose.ui.theme.PokedexComposeTheme
import com.bumptech.glide.integration.compose.GlideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Displaying edge-to-edge
        setContent {
            PokedexComposeTheme {
                PokeApp()
            }
        }

    }
}