plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dab.android.feature.home"
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:ui"))

    Dependencies.Compose.forEach(::implementation)
    implementation(Dependencies.Ktx.Accompanist)
    implementation(Dependencies.Jetpack.Hilt)
    implementation(Dependencies.Coroutine)

    implementation(Dependencies.Orbit.Main)
    implementation(Dependencies.Image.Coil)

    kapt(Dependencies.Compiler.Hilt)
}