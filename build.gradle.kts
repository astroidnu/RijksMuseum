/**
 * Apply Dependencies Library From Gradle Scripts
 * */

apply {
    from("gradle-scripts/dependencies.gradle")
}

buildscript {
    val kotlinVersion by extra("1.3.30")
    val objectBoxVersion by extra("1.5.0")
    val gradleVersion by extra("3.4.1")
    val sonarqubeVersion by extra("2.7")

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("io.objectbox:objectbox-gradle-plugin:$objectBoxVersion")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:$sonarqubeVersion")
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
