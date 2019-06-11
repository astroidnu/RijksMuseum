/**
 * Apply Dependencies Library From Gradle Scripts
 * */

apply {
    from("gradle-scripts/dependencies.gradle")
}

buildscript {
    val kotlinVersion by extra("1.3.30")
    val objectBoxVersion by extra("1.5.0")

    repositories {
        google()
        jcenter()
        maven ("https://jitpack.io")
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("io.objectbox:objectbox-gradle-plugin:$objectBoxVersion")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.7")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.0.0-RC14"
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
