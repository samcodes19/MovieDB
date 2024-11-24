// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp.android) apply false
//    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false

//    classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.0.0")

}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    buildscript {
        dependencies {
            classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
        }
    }
}



