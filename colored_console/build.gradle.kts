import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")

    id("kotlin")

    id("com.github.dcendents.android-maven")
}

group = "com.github.MohamedAlaaEldin636"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"
