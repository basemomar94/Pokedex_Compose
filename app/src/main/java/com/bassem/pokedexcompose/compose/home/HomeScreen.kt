package com.bassem.pokedexcompose.compose.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.pokedexcompose.R
import com.bassem.pokedexcompose.data.ResultX
import com.bassem.pokedexcompose.viewmodels.PokeViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlin.random.Random

@Composable
fun HomeScreen(viewModel: PokeViewModel = hiltViewModel()) {
    val pokeResult by viewModel.pokeResult.collectAsState()
    pokeResult?.let { _pokeResult ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(
                count = _pokeResult.results.size,
                key = { pokemon -> pokemon }
            ) { index ->
                val pokemon = _pokeResult.results[index]
                PokemonItem(pokemon)
            }
        }

    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonItem(pokemon: ResultX) {
    val pokeIconsList = listOf(
        R.drawable.pokemon_icon,
        R.drawable.cat,
        R.drawable.pink,
        R.drawable.pikachu,
        R.drawable.dog,
        R.drawable.pig
    )
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                model = pokeIconsList[Random.nextInt(0, pokeIconsList.size)],
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp),
                contentScale = ContentScale.Inside
            )
            Text(text = pokemon.name ?: "")
        }
    }
}
