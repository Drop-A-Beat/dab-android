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
        applicationId = "com.dab.android.app"
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
    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))

    implementation(project(":feature:home"))
    implementation(project(":feature:playlist"))
    implementation(project(":feature:search"))
    implementation(project(":feature:info"))

    implementation(Dependencies.Ktx.Core)
    implementation(Dependencies.Ktx.Trace)
    implementation(Dependencies.Ktx.AppCompat)
    implementation(Dependencies.Ktx.Material)
    implementation(Dependencies.Ktx.Accompanist)
    implementation(Dependencies.Ktx.Splash)


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