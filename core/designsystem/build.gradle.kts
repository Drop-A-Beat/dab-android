plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.dab.android.core.designsystem"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    Dependencies.Compose.forEach(::implementation)
}