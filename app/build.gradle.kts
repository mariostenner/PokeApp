plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.kotlin.kapt)
    //kotlin("kapt")
    alias(libs.plugins.hilt.android)

    alias(libs.plugins.googleServices)
    alias(libs.plugins.crashlytics)

   alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.mariods.pokeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mariods.pokeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Viewmodel
    //implementation(libs.androidx.lifecycle.viewmodel.compose)
    //implementation(libs.androidx.hilt.lifecycle.viewmodel)
    //implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.runtime.livedata)
    kapt(libs.hilt.android.compiler)
    androidTestImplementation(libs.hilt.android.testing)

    //Navigation
    implementation(libs.hilt.navigation.compose)
    //Serializable for implement navigation with safe methods
    implementation(libs.kotlinx.serialization.json)

    //Compose
    implementation(libs.androidx.navigation.compose)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.authentication)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}