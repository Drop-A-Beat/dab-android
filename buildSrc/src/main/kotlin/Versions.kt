import org.gradle.api.JavaVersion

object Versions {
    const val minSdk = 23
    const val targetSdk = 33
    const val compileSdk = 33
    const val jvmTarget = "11"
    const val versionCode = 11
    const val versionName = "0.0.0"
    val javaVersion = JavaVersion.VERSION_11

    object Ktx {
        const val Core = "1.8.0"
        const val Trace = "1.1.0"
        const val AppCompat = "1.5.1"
        const val Material = "1.7.0"
        const val Fragment = "1.4.1"
        const val Activity = "1.4.0"
        const val Lifecycle = "2.4.1"
        const val Accompanist = "0.27.0"
        const val Splash = "1.0.0"
    }

    object Essential {
        const val Kotlin = "1.6.21"
        const val Coroutines = "1.6.2"
    }

    object Compose {
        const val Main = "1.2.0-rc01"
        const val Meterial3 = "1.0.1"
        const val Preview = "1.4.0-alpha02"
        const val Activity = "1.6.0-alpha05"
        const val Landscapist = "1.5.2"
        const val ConstraintLayout = "1.0.1"
        const val LifecycleCompose = "2.6.0-alpha01"
        const val Accompanist = "0.24.4-alpha"
        const val HiltNavigation = "1.0.0-beta01"
        const val Navigation = "2.6.0-alpha04"
        const val Coil = "2.2.2"
    }

    object Jetpack {
        const val Hilt = "2.42"
        const val Room = "2.4.2"
        const val DataStore = "1.0.0"
    }

    object Network {
        const val OkHttp = "4.9.3"
        const val Retrofit = "2.9.0"
    }

    object MVI {
        const val Orbit = "4.3.2"
    }

    object Ui {
        const val Browser = "1.3.0"
        const val Material = "1.6.0-alpha03"
        const val Splash = "1.0.0-beta02"
        const val ConstraintLayout = "2.1.3"
    }

    object Test {
        const val JUnit = "5.8.2"
        const val JaCoCo = "0.8.8"
        const val Hamcrest = "2.2"
        const val Coroutine = "1.6.2"
        const val JUnitGradle = "1.8.2.0"
    }

    object Util {
        const val Erratum = "1.0.1"
        const val Logeukes = "1.0.0"
        const val Jackson = "2.13.1"
        const val Scabbard = "0.5.0"
        const val LeakCanary = "2.9.1"
        const val SecretsGradlePlugin = "2.0.0"
    }

}
