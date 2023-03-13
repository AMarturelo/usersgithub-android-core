buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(ClasspathDependencies.androidGradlePlugin)
        classpath(ClasspathDependencies.kotlinGradlePlugin)
        classpath(ClasspathDependencies.hiltPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}