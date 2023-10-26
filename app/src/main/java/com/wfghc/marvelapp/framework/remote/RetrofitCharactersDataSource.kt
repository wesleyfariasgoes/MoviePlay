package com.wfghc.marvelapp.framework.remote

import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.marvelapp.framework.network.MarvelApi
import com.wfghc.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
) : CharactersRemoteDataSource<DataWrapperResponse> {
    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries = queries)
    }
}