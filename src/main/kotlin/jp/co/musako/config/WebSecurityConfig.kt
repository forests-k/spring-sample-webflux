package jp.co.musako.config

import org.springframework.context.annotation.*
import org.springframework.security.config.annotation.web.reactive.*
import org.springframework.security.config.web.server.*
import org.springframework.security.web.server.*

@EnableWebFluxSecurity
class WebSecurityConfig {

  @Bean
  fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    http.csrf()
      .disable()
    http
      .authorizeExchange()
      .pathMatchers("/**")
      .permitAll()
      .and()
      .httpBasic()
      .disable()
    return http.build()
  }
}