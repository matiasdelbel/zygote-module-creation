import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }
}

repositories {
    mavenCentral()
    jcenter()
}

plugins { kotlin("jvm") version "1.3.72" }

sourceSets {
    main {
        withConvention(KotlinSourceSet::class) { kotlin.srcDirs("src/main/kotlin") }
    }

    named("test") {
        withConvention(KotlinSourceSet::class) { kotlin.srcDirs("src/test/kotlin", "src/test/fakes") }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt:clikt:2.6.0")

    testImplementation("junit:junit:4.12")
}