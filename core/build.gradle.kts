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

    // Coroutines
    api(ApplicationDependencies.coroutinesCore)
    api(ApplicationDependencies.coroutinesAndroid)

    api(ApplicationDependencies.xAppCompat)

    testImplementation(UnitTestingDependencies.junit)

    api(ApplicationDependencies.retrofit)
    api(ApplicationDependencies.retrofitGson)
    api(ApplicationDependencies.okhttpLoggingInterceptor)

    // hilt
    implementation(ApplicationDependencies.hiltAndroid)
    kapt(ApplicationDependencies.hiltAndroidCompiler)

    api(ApplicationDependencies.timber)
}

apply(from = "../publish-module.gradle")