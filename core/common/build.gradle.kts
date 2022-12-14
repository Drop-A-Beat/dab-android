plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dab.android.core.common"
}

dependencies {
    implementation(project(mapOf("path" to ":core:data")))
    implementation(project(mapOf("path" to ":core:model")))

    implementation(Dependencies.Jetpack.Hilt)
    implementation(Dependencies.Coroutine)

    implementation(Dependencies.Orbit.Main)

    kapt(Dependencies.Compiler.Hilt)
}