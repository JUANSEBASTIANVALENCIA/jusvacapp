plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.jusvacapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jusvacapp"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}


dependencies {
    // Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Retrofit2 -> Convert fast JSON to GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Coroutines Library -> Background request
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    // Activity
    implementation("androidx.activity:activity-ktx:1.2.2")
    // Recycler View
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

