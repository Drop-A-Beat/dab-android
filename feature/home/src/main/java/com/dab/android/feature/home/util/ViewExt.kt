package com.dab.android.feature.home.util

import androidx.compose.foundation.ScrollState

const val SCROLL_STATE = 300

fun ScrollState.isInside(): Boolean = value < SCROLL_STATE