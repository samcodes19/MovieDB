plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}


android {
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
//    dataBinding {
//        enabled = true
//    }

    namespace = "com.example.moviedb"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.example.moviedb"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx")
    implementation("androidx.room:room-runtime:2.6.1")

    implementation("androidx.room:room-ktx:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")  // for Java

    ksp(libs.androidx.room.compiler)
    implementation("androidx.room:room-runtime:2.5.0")


    // Other dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")  // Kotlin standard library
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Optional: Room Testing
    testImplementation("androidx.room:room-testing:2.5.0")

}
