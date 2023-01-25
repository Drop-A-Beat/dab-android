plugins {
    id("dab.android.library")
    id("dab.android.library.compose")
}

android {
    namespace = "com.dab.android.core.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
}