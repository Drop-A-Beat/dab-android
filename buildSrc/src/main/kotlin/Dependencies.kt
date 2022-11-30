object Dependencies {
    const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"

    object Orbit {
        const val Test = "org.orbit-mvi:orbit-test:${Versions.MVI.Orbit}"
        const val Main = "org.orbit-mvi:orbit-viewmodel:${Versions.MVI.Orbit}"
    }

    object Ktx {
        const val Core = "androidx.core:core-ktx:${Versions.Ktx.Core}"
        const val Trace = "androidx.tracing:tracing-ktx:${Versions.Ktx.Trace}"
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.Ktx.AppCompat}"
        const val Material = "com.google.android.material:material:${Versions.Ktx.Material}"
        const val Fragment = "androidx.fragment:fragment-ktx:${Versions.Ktx.Fragment}"
        const val Activity = "androidx.activity:activity-ktx:${Versions.Ktx.Activity}"
        const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.Lifecycle}"
        const val Accompanist = "com.google.accompanist:accompanist-systemuicontroller:${Versions.Ktx.Accompanist}"
        const val Splash = "androidx.core:core-splashscreen:${Versions.Ktx.Splash}"
    }

    object Jetpack {
        const val Room = "androidx.room:room-ktx:${Versions.Jetpack.Room}"
        const val Hilt = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
        const val DataStore =
            "androidx.datastore:datastore-preferences:${Versions.Jetpack.DataStore}"
    }

    object Compiler {
        const val RoomKsp = "androidx.room:room-compiler:${Versions.Jetpack.Room}"
        const val Hilt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    object Debug {
        const val LeakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
        val Compose = listOf(
            "androidx.compose.ui:ui-tooling:${Versions.Compose.Main}",
            "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Main}"
        )
    }

    val Compose = listOf(
        "androidx.compose.material:material:${Versions.Compose.Main}",
        "androidx.compose.material3:material3:${Versions.Compose.Meterial3}",
        "androidx.compose.runtime:runtime-livedata:${Versions.Compose.Main}",
        "androidx.activity:activity-compose:${Versions.Compose.Activity}",
        "com.github.skydoves:landscapist-coil:${Versions.Compose.Landscapist}",
        "com.google.accompanist:accompanist-placeholder:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-swiperefresh:${Versions.Compose.Accompanist}",
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.LifecycleCompose}",
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Compose.LifecycleCompose}",
        "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.Accompanist}",
        "androidx.hilt:hilt-navigation-compose:${Versions.Compose.HiltNavigation}",
        "androidx.navigation:navigation-compose:${Versions.Compose.Navigation}"
    )

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.retrofit2:converter-jackson:${Versions.Network.Retrofit}"
    )

    val Test = listOf(
        "org.hamcrest:hamcrest:${Versions.Test.Hamcrest}",
        "org.junit.jupiter:junit-jupiter-api:${Versions.Test.JUnit}",
        "org.junit.jupiter:junit-jupiter-engine:${Versions.Test.JUnit}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.Coroutine}"
    )


}