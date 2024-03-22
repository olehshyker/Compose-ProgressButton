
plugins {
    id("build.android.library")
    id("build.android.library.compose")
    id("build.spotless")
}

android {
    namespace = "com.olehsh.progressButton"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.constraintlayout)

    implementation(libs.androidx.appcompat)

}