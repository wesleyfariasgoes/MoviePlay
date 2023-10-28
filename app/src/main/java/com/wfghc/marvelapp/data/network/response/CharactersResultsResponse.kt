package com.wfghc.marvelapp.data.network.response

import com.wfghc.core.domain.model.Character

data class CharactersResultsResponse(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailResponse
)

fun CharactersResultsResponse.toCharacterModel() : Character {
    return Character(
        name = name,
        imageUrl = "${this.thumbnail.path}.${this.thumbnail.extension}"
            .replace("http","https")
    )
}
