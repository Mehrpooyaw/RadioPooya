plugins {
    id("com.android.application")
    kotlin("android")

}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.radiojavan.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-rc02"
    }
}
val composeVersion = "1.2.0-rc02"

dependencies {
    implementation(project(":radioJavanShared"))
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation ("androidx.core:core-ktx:1.8.0")
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$composeVersion")

    // Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.5.0-rc02")

    implementation ("io.insert-koin:koin-androidx-compose:3.2.0")

    implementation ("com.soywiz.korlibs.klock:klock:3.0.0-Beta5")

    implementation ("androidx.media3:media3-exoplayer:1.0.0-beta01")
    implementation ("androidx.media3:media3-ui:1.0.0-beta01")
    implementation("io.coil-kt:coil-compose:1.4.0")

    // Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.24.10-beta")
    implementation ("com.google.accompanist:accompanist-placeholder-material:0.24.10-beta")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.24.10-beta")
    implementation ("com.google.accompanist:accompanist-flowlayout:0.24.13-rc")


    // -- Accompanist pager
    implementation ("com.google.accompanist:accompanist-pager:0.23.1")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.22.0-rc")
    implementation ("androidx.compose.ui:ui-util:1.2.0-rc02")


}
