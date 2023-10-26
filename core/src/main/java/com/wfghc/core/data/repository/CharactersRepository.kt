package com.wfghc.core.data.repository

import androidx.paging.PagingSource
import com.wfghc.core.domain.model.Character

interface CharactersRepository {
    fun getCharacters(query: String) : PagingSource<Int,Character>
}