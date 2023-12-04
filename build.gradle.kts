import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    id("java")
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.adarshr.test-logger") version "4.0.0"
}

group = "ru.tinkoff.fintech.qa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //spring
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springdoc:springdoc-openapi-ui:1.5.8")
    implementation("io.swagger:swagger-annotations:1.6.1")
    implementation("org.openapitools:jackson-databind-nullable:0.2.1")

    testImplementation("io.rest-assured:rest-assured-all:4.1.2")
    testImplementation("io.rest-assured:rest-assured:4.1.2")

    //db
    implementation("org.postgresql:postgresql:42.4.3")

    //tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

testlogger{
    theme = ThemeType.MOCHA
}

tasks.test {
    useJUnitPlatform()
}


tasks.jar {
    manifest.attributes["Main-Class"] = "ru.tinkoff.fintech.qa.Application"
}