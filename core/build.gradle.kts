plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}

kapt {
    correctErrorTypes = true
}

android {
    compileSdk = VersionApp.compileSdkVersion

    defaultConfig {
        minSdk = VersionApp.minSdkVersion
        targetSdk = VersionApp.targetSdkVersion
        renderscriptSupportModeEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // Coroutines
    implementation(ApplicationDependencies.coroutinesCore)
    implementation(ApplicationDependencies.coroutinesAndroid)

    //dagger
    implementation(ApplicationDependencies.dagger)
    implementation(ApplicationDependencies.daggerAndroid)
    implementation(ApplicationDependencies.daggerSupport)
    kapt(ApplicationDependencies.daggerCompiler)
    kapt(ApplicationDependencies.daggerAdroidProcessor)

    //Logger
    implementation(ApplicationDependencies.timber)
}