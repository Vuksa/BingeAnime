// Top-level build file where you can add configuration options common to all sub-projects/modules.

import io.gitlab.arturbosch.detekt.Detekt

plugins {
  id("io.gitlab.arturbosch.detekt") version "1.19.0-RC2"
}

buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.3")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0-RC2")
    classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0-RC2")

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

subprojects {
  apply {
    plugin("io.gitlab.arturbosch.detekt")
  }

  tasks.withType<Detekt> {
    reports {
      html {
        required.set(true)
        outputLocation.set(File(buildDir, "reports/detekt/detekt.html"))
      }
      xml {
        required.set(true)
        outputLocation.set(File(buildDir, "reports/detekt/detekt.xml"))
      }
    }
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
