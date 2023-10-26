package com.wfghc.marvelapp.framework.network.response

data class CharactersResultsResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailResponse
)
