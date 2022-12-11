package com.dab.android.core.data.mapper

import com.dab.android.core.data.RemoteException
import com.dab.android.core.model.base.ErrorRecord
import com.dab.android.core.model.base.Record

class ErrorMapper {
    fun <T>mapErrorRecord(e: RemoteException): Record<T> {
        val errorRecord: ErrorRecord = when(e) {
            is RemoteException.ClientError -> ErrorRecord.ClientError
            is RemoteException.ServerError -> ErrorRecord.ServerError
            is RemoteException.NoNetworkError -> ErrorRecord.NetworkError
            else -> ErrorRecord.GenericError
        }
        return Record(null, errorRecord)
    }
}