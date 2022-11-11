plugins {
    id("com.android.application")
//    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dab.android.app"
    defaultConfig {
        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }
    buildTypes {
        debug {
            aaptOptions.cruncherEnabled = false // png optimization (default: true)
        }

        // TODO
        /*release {
            signingConfig = signingConfigs.getByName("release")
        }*/
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}
dependencies {
    val dependencies = listOf(
        Dependencies.Jetpack.Hilt,
    ).dependenciesFlatten()
    dependencies.forEach(::implementation)

    implementation(Dependencies.Orbit.Main)
    implementation(Dependencies.Jetpack.Hilt)
    kapt(Dependencies.Compiler.Hilt)
    Dependencies.Compose.forEach(::implementation)
    Dependencies.Debug.Compose.forEach(::debugImplementation)

    testImplementation(Dependencies.Orbit.Test)
    Dependencies.Test.forEach { testDependency ->
        testImplementation(testDependency)
    }
}