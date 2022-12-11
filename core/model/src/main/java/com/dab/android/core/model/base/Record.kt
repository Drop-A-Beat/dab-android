package com.dab.android.core.model.base

data class Record<out R>(
    val data: R?,
    val error: ErrorRecord? = null
)
