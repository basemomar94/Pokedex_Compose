package com.bassem.pokedexcompose.api

import com.bassem.pokedexcompose.data.PokeResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeService {

    @GET("pokemon")
    suspend fun getPokeList(): PokeResult

    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        fun create(): PokeService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PokeService::class.java)
        }

    }
}