plugins {
    id("dab.android.library")
    id("dab.android.hilt")
}

android {
    namespace = "com.dab.android.core.common"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.orbit.viewmodel)
}