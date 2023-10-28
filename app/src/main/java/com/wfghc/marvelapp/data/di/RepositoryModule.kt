package com.wfghc.marvelapp.data.di

import com.wfghc.core.data.repository.CharactersRemoteDataSource
import com.wfghc.core.data.repository.CharactersRepository
import com.wfghc.marvelapp.data.CharactersRepositoryImpl
import com.wfghc.marvelapp.data.network.response.DataWrapperResponse
import com.wfghc.marvelapp.data.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun characterRepository(
        respository: CharactersRepositoryImpl
    ): CharactersRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersDataSource
    ): CharactersRemoteDataSource<DataWrapperResponse>
}