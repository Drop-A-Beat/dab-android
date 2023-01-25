plugins {
    id("dab.android.library")
    id("dab.android.library.compose")
}

android {
    namespace = "com.dab.android.core.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    api(libs.accompanist.systemuicontroller)
    api(libs.androidx.tracing.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}