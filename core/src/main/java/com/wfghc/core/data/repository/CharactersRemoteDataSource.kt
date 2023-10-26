package com.wfghc.core.data.repository

interface CharactersRemoteDataSource<T> {
    suspend fun fetchCharacters(queries: Map<String,String>) : T
}