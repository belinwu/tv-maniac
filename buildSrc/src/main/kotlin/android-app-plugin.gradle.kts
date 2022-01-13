@file:Suppress("UnstableApiUsage")

import util.libs

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = libs.versions.android.compile.get().toInt()

    defaultConfig {
        applicationId = "com.thomaskioko.tvmaniac"
        minSdk = libs.versions.android.min.get().toInt()
        targetSdk = libs.versions.android.target.get().toInt()
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            multiDexEnabled = true
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    dependencies {

        implementation(libs.hilt.android)
        implementation(libs.hilt.navigation)
        kapt(libs.hilt.compiler)

        implementation(libs.kermit)
        implementation(libs.ktor.android)

        debugImplementation(libs.squareup.leakcanary)

        coreLibraryDesugaring(libs.desugar)
    }
}
