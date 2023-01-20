plugins {
    id("dab.android.library")
    id("dab.android.hilt")
}

android {
    namespace = "com.dab.android.core.domain"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
}