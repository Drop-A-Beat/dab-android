plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id ("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dab.android.core.domain"
}

dependencies {
    implementation(project(":core:model"))

    implementation(Dependencies.Jetpack.Hilt)
    implementation(Dependencies.Coroutine)
    kapt(Dependencies.Compiler.Hilt)
}