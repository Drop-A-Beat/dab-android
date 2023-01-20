package com.dab.android

@Suppress("unused")
enum class DabBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE
}
