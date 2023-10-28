package com.wfghc.marvelapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.data.network.response.DataWrapperResponse
import com.wfghc.marvelapp.data.network.response.toCharacterModel

class CharactersPagingSource(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>,
    private val query: String
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
               anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.plus(1)
        }
    }

    @Suppress("TooGenericExceptionCaught")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val offset = params.key ?: 0
            val queries = hashMapOf(
                "offset" to offset.toString()
            )
            if (query.isNotEmpty()) {
                queries["nameStartsWith"] = query
            }

            val response = remoteDataSource.fetchCharacters(queries)
            val responseOffset = response.data.offset
            val responseTotal = response.data.total

            LoadResult.Page(
                data = response.data.results.map { it.toCharacterModel() },
                prevKey = null,
                nextKey = if (responseOffset < responseTotal) {
                    responseOffset + LIMIT
                } else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}