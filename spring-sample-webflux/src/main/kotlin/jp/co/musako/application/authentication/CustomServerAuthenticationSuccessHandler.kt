package jp.co.musako.application.authentication

import org.springframework.http.*
import org.springframework.security.core.*
import org.springframework.security.web.server.*
import org.springframework.security.web.server.authentication.*
import org.springframework.stereotype.*
import reactor.core.publisher.*

@Service
class CustomServerAuthenticationSuccessHandler : ServerAuthenticationSuccessHandler {

  override fun onAuthenticationSuccess(
    webFilterExchange: WebFilterExchange,
    authentication: Authentication
  ): Mono<Void> = Mono.fromRunnable {
    webFilterExchange.exchange.response.statusCode = HttpStatus.OK
  }
}