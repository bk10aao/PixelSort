plugins {
    id("java")
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("jacoco")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

group = "snippets"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.4.4")
    implementation("com.fasterxml.jackson.core:jackson-core:2.19.0")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    maxHeapSize = "4096m"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco"))
    }
    sourceSets(sourceSets.main.get())
    classDirectories.setFrom(
        files(sourceSets.main.get().output.asFileTree.matching {
            include("visualizer/Controller/Algorithms/**")
            exclude("visualizer/Controllers/**")
        })
    )
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}