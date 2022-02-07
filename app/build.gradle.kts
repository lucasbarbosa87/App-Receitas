import Libraries.guava
import android.annotation.SuppressLint

val composeVersion = "1.0.0"
val appVersionName = "1.0.0"

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.github.ben-manes.versions") version "0.41.0"
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AndroidSdk.target
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "br.com.lucas.receitas"
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = Functions.generateAppVersionCode(appVersionName = appVersionName)
        versionName = appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    viewBinding {
        isEnabled = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc03"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.core:core-splashscreen:1.0.0-beta01")

    roomDb()
    lifecycleLibs()
    navigation()
    retrofit(ConfigurationType.Implementation)
    paging(ConfigurationType.Implementation)
    firebase(ConfigurationType.Implementation, true)
    hilt(ConfigurationType.Implementation, true)

    implementation(guava)
    implementation(Libraries.workManager)
    implementation(Libraries.jodaTime)
    implementation(Libraries.viewPager2)
    implementation(Libraries.gson)
}

