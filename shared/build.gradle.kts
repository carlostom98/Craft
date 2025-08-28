import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines)
        }

        androidMain.dependencies {
            implementation(libs.android.lifecycle.mvvm)
        }

        iosMain.dependencies {

        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:null")
    }
    sourceSets.iosMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:null")
    }
}

android {
    namespace = "org.carams.project.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
