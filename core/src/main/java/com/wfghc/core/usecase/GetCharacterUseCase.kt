package com.wfghc.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wfghc.core.data.repository.CharactersRepository
import com.wfghc.core.domain.model.Character
import com.wfghc.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
): PagingUseCase<GetCharacterUseCase.GetCharacterParams, Character>() {

    override fun createFlowObservable(params: GetCharacterParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig){
            charactersRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharacterParams(val query: String, val pagingConfig: PagingConfig)
}