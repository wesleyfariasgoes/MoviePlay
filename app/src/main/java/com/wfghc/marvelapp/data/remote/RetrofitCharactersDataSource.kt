package com.wfghc.marvelapp.data.remote

import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.marvelapp.data.network.MarvelApi
import com.wfghc.marvelapp.data.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
) : CharactersRemoteDataSource<DataWrapperResponse> {
    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries = queries)
    }
}