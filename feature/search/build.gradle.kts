plugins {
    id("dab.android.library")
    id("dab.android.library.compose")
    id("dab.android.hilt")
}

android {
    namespace = "com.dab.android.feature.search"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.orbit.viewmodel)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
}