plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.dab.android.core.data"

    defaultConfig {
        buildConfigField("String", "BASE_URL","\"https://raw.githubusercontent.com/\"")
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(Dependencies.Ktx.Core)
    implementation(Dependencies.Coroutine)
    implementation(Dependencies.Jetpack.Hilt)

    Dependencies.Network.forEach(::implementation)

    kapt(Dependencies.Compiler.Hilt)
}