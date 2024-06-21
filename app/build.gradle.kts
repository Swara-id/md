import android.databinding.tool.writer.ViewBinding

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.swaraapp"
    compileSdk = 34
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
    defaultConfig {
        applicationId = "com.example.swaraapp"
        minSdk = 30
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
}

dependencies {
    // CameraX Core library
    implementation("androidx.camera:camera-core:1.3.4")
    // CameraX Camera2 implementation
    implementation("androidx.camera:camera-camera2:1.3.4")
    // CameraX Lifecycle library
    implementation("androidx.camera:camera-lifecycle:1.3.4")
    // CameraX View library
    implementation("androidx.camera:camera-view:1.3.4")
    // CameraX Extensions library
    implementation("androidx.camera:camera-extensions:1.3.4")
    // Picasso
    implementation("com.squareup.picasso:picasso:2.71828")
    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    // Mediapipe
    implementation("com.google.mediapipe:hands:0.10.14")
    // Tensorflow Lite
    implementation("org.tensorflow:tensorflow-lite:2.8.0")
    implementation("org.tensorflow:tensorflow-lite-gpu:2.8.0")
    implementation("org.tensorflow:tensorflow-lite-support:0.3.1")
    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")
    // Lifecycle libraries
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    // AndroidX Core and AppCompat
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    // Material Components
    implementation("com.google.android.material:material:1.12.0")
    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Activity KTX
    implementation("androidx.activity:activity-ktx:1.2.3")
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

