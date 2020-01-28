package jp.co.musako.application.authentication

import org.slf4j.*
import org.springframework.http.*
import org.springframework.security.core.*
import org.springframework.security.web.server.*
import org.springframework.stereotype.*
import org.springframework.web.server.*
import reactor.core.publisher.*

@Service
class CustomServerAuthenticationEntryPoint : ServerAuthenticationEntryPoint {

  companion object {
    private val log = LoggerFactory.getLogger(CustomServerAuthenticationEntryPoint::class.java)
  }

  override fun commence(exchange: ServerWebExchange, e: AuthenticationException): Mono<Void> {
    return Mono.fromRunnable {
      log.warn("authentication forbidden")
      exchange.response.statusCode = HttpStatus.FORBIDDEN
    }
  }
}