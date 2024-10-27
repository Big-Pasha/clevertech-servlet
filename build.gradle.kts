plugins {
    id("java")
    id("war")
}

group = "org.clevertech.servlet.pz"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val lombokVersion = "1.18.30"
val servletVersion = "4.0.1"
val slf4jVersion = "1.7.30"
val junitVersion = "5.10.0"


repositories {
    mavenCentral()
}

dependencies {
    compileOnly("javax.servlet:javax.servlet-api:$servletVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")

    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}