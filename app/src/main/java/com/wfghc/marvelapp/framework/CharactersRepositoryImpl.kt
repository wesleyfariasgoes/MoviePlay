package com.wfghc.marvelapp.framework

import androidx.paging.PagingSource
import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.core.data.repository.CharactersRepository
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
): CharactersRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPaging()
    }

}