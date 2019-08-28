package jp.co.musako

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSampleJpaApplication

fun main(args: Array<String>) {
    runApplication<SpringSampleJpaApplication>(*args)
}
