package com.wfghc.core.usecase.base

import kotlinx.coroutines.CoroutineDispatcher

data class AppCoroutinesDispatches(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)
