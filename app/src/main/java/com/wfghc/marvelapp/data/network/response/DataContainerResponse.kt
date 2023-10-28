package com.wfghc.marvelapp.data.network.response

data class DataContainerResponse(
    val offset: Int,
    val total: Int,
    val results: List<CharactersResultsResponse>
)
