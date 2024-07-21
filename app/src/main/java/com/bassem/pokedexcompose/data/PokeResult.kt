package com.bassem.pokedexcompose.data

data class PokeResult(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultX>
)