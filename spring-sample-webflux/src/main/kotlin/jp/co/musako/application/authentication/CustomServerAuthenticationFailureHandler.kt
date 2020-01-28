package jp.co.musako.application.authentication

import org.slf4j.*
import org.springframework.http.*
import org.springframework.security.core.*
import org.springframework.security.web.server.*
import org.springframework.security.web.server.authentication.*
import org.springframework.stereotype.*
import reactor.core.publisher.*

@Service
class CustomServerAuthenticationFailureHandler : ServerAuthenticationFailureHandler {

  companion object {
    private val log = LoggerFactory.getLogger(CustomServerAuthenticationFailureHandler::class.java)
  }

  override fun onAuthenticationFailure(
    webFilterExchange: WebFilterExchange,
    exception: AuthenticationException
  ): Mono<Void> = Mono.fromRunnable {
    log.warn("authentication failure")
    webFilterExchange.exchange.response.statusCode = HttpStatus.FORBIDDEN
  }
}