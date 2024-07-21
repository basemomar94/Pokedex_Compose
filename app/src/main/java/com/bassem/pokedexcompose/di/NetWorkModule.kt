package com.bassem.pokedexcompose.di

import com.bassem.pokedexcompose.api.PokeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetWorkModule {
    @Singleton
    @Provides
    fun provideApiService(): PokeService {
        return PokeService.create()
    }
}