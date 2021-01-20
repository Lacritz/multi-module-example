plugins {
    kotlin("jvm")
    id("java-library")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    api(project(":platform:api"))
}
