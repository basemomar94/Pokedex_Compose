package com.bassem.pokedexcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.pokedexcompose.data.PokeRepo
import com.bassem.pokedexcompose.data.PokeResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(private val pokeRepo: PokeRepo) : ViewModel() {
    private val _pokeResult = MutableStateFlow<PokeResult?>(null)
    val pokeResult: StateFlow<PokeResult?> get() = _pokeResult.asStateFlow()

    init {
        getPokeResult()
    }

    private fun getPokeResult() = viewModelScope.launch {
        try {
            _pokeResult.value = pokeRepo.getPokeResult().first()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}