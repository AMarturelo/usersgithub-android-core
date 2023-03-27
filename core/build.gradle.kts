plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
    `maven-publish`
}

group = ConfigData.groupName
version = ConfigData.versionName

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

publishing {
    repositories {
        maven {
            name = "GitHub"
            url = uri("https://maven.pkg.github.com/amarturelo/usersgithub-android-core")
            credentials {
                username = (System.getenv("GITHUB_USER") ?: project.properties["GITHUB_USER"]).toString()
                password = (System.getenv("GITHUB_ACCESS_TOKEN")
                    ?: project.properties["GITHUB_ACCESS_TOKEN"]).toString()
            }
        }
    }
    publications {
        register("core", MavenPublication::class) {
            groupId = ConfigData.groupName
            artifactId = ConfigData.artifactId
            version = ConfigData.versionName
            artifact("$buildDir/outputs/aar/${project.name}-release.aar")
        }
    }
}