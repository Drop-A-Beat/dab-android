plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dab.android.core.data"
}

dependencies {
    implementation(Dependencies.Ktx.Core)
    implementation(Dependencies.Coroutine)
    implementation(Dependencies.Jetpack.Hilt)
    kapt(Dependencies.Compiler.Hilt)
}