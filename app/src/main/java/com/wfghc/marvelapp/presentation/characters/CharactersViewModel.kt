package com.wfghc.marvelapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.wfghc.core.domain.model.Character
import com.wfghc.core.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    fun charactersPagingData(query: String): Flow<PagingData<Character>> {
        return getCharacterUseCase(
            GetCharacterUseCase.GetCharacterParams(query,getPageConfig())
        ).cachedIn(viewModelScope)
    }

    @Suppress("MagicNumber")
    private fun getPageConfig() = PagingConfig(
        pageSize = 20
    )
}