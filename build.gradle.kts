plugins {
    id("java")
    id("io.freefair.lombok") version "6.5.1"
    id("war")
}

group = "org.clevertech.servlet.pz"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val lombokVersion = "1.18.30"
val servletVersion = "4.0.1"
val slf4jVersion = "2.0.12"
val junitVersion = "5.10.0"
val mapStructVersion = "1.5.5.Final"
val morphiaVersion = "2.0.0"
val gsonVersion = "2.9.0"


repositories {
    mavenCentral()
}

dependencies {
    compileOnly("javax.servlet:javax.servlet-api:$servletVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")

    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("dev.morphia.morphia:morphia-core:$morphiaVersion")
    implementation("org.mapstruct:mapstruct:$mapStructVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")

    annotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}