plugins {
    id("dab.android.library")
    id("dab.android.hilt")
}

android {
    namespace = "com.dab.android.core.data"

    defaultConfig {
        buildConfigField("String", "BASE_URL","\"https://raw.githubusercontent.com/\"")
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
}