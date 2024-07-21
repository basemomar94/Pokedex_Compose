package com.bassem.pokedexcompose.data

import kotlinx.coroutines.flow.Flow
import com.bassem.pokedexcompose.api.PokeService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokeRepo @Inject constructor(private val service: PokeService) {
    val pokeList: Flow<List<PokeResult>>? = null

    suspend fun getPokeResult() = flow {
        val pokeResult = service.getPokeList()
        emit(pokeResult)
    }
}