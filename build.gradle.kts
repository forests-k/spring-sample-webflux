import org.jetbrains.kotlin.gradle.tasks.*

plugins {
  id("org.springframework.boot") version "2.2.4.BUILD-SNAPSHOT"
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
  kotlin("jvm") version "1.3.61"
  kotlin("plugin.spring") version "1.3.61"
  kotlin("plugin.jpa") version "1.3.61"
  id("org.jetbrains.dokka") version "0.9.18"
  id("org.flywaydb.flyway") version "6.0.0"
}

group = "jp.co.musako"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  mavenCentral()
  jcenter()
  maven { url = uri("https://repo.spring.io/milestone") }
  maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  implementation("org.projectreactor:reactor-spring:1.0.1.RELEASE")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")

  implementation("javax.xml.bind:jaxb-api:2.3.0")
  implementation("com.sun.xml.bind:jaxb-core:2.3.0")
  implementation("com.sun.xml.bind:jaxb-impl:2.3.0")

  runtime("mysql:mysql-connector-java")

  compileOnly("org.projectlombok:lombok:1.18.6")
  annotationProcessor("org.projectlombok:lombok:1.18.6")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

//kotlin {
//    experimental {
//        coroutines = "enable"
//    }
//}