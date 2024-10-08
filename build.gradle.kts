plugins {
    id("java")
}

group = "org.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven (url="https://jitpack.io")
}

dependencies {
    implementation("com.github.woowacourse-projects:mission-utils:1.1.0")
    // JUnit5
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.test {
    useJUnitPlatform()
}