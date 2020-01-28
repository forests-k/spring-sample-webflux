package jp.co.musako.application.authentication

import jp.co.musako.application.authentication.model.*
import org.springframework.http.codec.*
import org.springframework.http.server.reactive.*
import org.springframework.security.core.*
import org.springframework.security.web.server.authentication.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.*
import org.springframework.web.server.*
import reactor.core.publisher.*
import java.util.*

@Service
class JsonBodyAuthenticationConverter(
  val messageReaders: List<HttpMessageReader<*>>
) : ServerAuthenticationConverter {

  override fun convert(exchange: ServerWebExchange): Mono<Authentication> {
    return BodyExtractors.toMono(Credential::class.java)
      .extract(exchange.request, object : BodyExtractor.Context {
        override fun messageReaders(): List<HttpMessageReader<*>> = messageReaders
        override fun serverResponse(): Optional<ServerHttpResponse> = Optional.of(exchange.response)
        override fun hints(): Map<String, Any> = mapOf()
      })
      .map { it.toToken() }
  }
}