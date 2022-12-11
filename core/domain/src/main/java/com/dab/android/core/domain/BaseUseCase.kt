package com.dab.android.core.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<REQUEST, RESPONSE> {

    open val dispatcher: CoroutineDispatcher = Dispatchers.IO

    operator fun invoke(
        request: REQUEST? = null
    ): Flow<RESPONSE> = flow {
        emit(run(request = request))
    }.flowOn(dispatcher)

    abstract suspend fun run(request: REQUEST?): RESPONSE
}