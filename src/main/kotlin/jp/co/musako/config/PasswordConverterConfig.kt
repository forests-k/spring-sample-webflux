package jp.co.musako.config

import org.springframework.context.annotation.*
import org.springframework.security.crypto.password.*

@Configuration
class PasswordConverterConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = Pbkdf2PasswordEncoder()
}