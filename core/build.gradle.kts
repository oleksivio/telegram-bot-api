plugins {
    kotlin("jvm")
    id("nebula.javadoc-jar")
    id("nebula.source-jar")
}

val versionInfo: VersionInfo by rootProject.loadVersionInfo()

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    // telegram server api dependency
    implementation(project(":server-api"))
    // logger api
    implementation("org.slf4j:slf4j-api:${versionInfo.sl4jVersion}")
}
