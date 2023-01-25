plugins {
    id("dab.android.library")
    id("dab.android.library.compose")
    id("dab.android.hilt")
}

android {
    namespace = "com.dab.android.feature.home"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:ui"))

    implementation(libs.accompanist.swiperefresh)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.orbit.viewmodel)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}