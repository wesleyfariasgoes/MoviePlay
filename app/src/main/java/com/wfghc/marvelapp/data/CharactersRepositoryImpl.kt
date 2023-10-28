package com.wfghc.marvelapp.data

import androidx.paging.PagingSource
import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.core.data.repository.CharactersRepository
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.data.network.response.DataWrapperResponse
import com.wfghc.marvelapp.data.paging.CharactersPagingSource
import javax.inject.Inject

@Suppress("UnusedPrivateProperty")
class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
): CharactersRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource,query = query)
    }

}