package com.example.rickandmortylist.data

import com.example.rickandmortylist.model.Character

class Datasource {
    fun loadCharacters(): List<Character> {
        return listOf<Character>(
            Character(
                "Rick Sanchez",
                "Alive",
                "Human",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            Character(
                "Morty Smith",
                "Alive",
                "Human",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            )
        )


    }
}