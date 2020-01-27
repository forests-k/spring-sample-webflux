package jp.co.musako.config

import io.netty.channel.*
import org.springframework.context.annotation.*
import org.springframework.http.client.reactive.*
import org.springframework.web.reactive.function.client.*
import reactor.netty.http.client.*

@Configuration
class WebClientConfig {

  @Bean
  fun resourceFactory() = ReactorResourceFactory().apply {
    isUseGlobalResources = false
  }

  @Bean
  fun webClient(): WebClient {

    val mapper: (HttpClient) -> HttpClient = {
      it.tcpConfiguration { it.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000) }
    }
    val connector = ReactorClientHttpConnector(resourceFactory(), mapper)
    return WebClient.builder().clientConnector(connector).build()
  }
}