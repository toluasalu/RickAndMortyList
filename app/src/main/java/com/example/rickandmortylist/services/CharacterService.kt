package com.example.rickandmortylist.services

import com.example.rickandmortylist.model.MyCharacter
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    fun getCharacterList(): Call<MyCharacter>
}