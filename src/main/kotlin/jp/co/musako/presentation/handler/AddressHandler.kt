package jp.co.musako.presentation.handler

import jp.co.musako.domain.model.*
import jp.co.musako.domain.service.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.*

@Component
class AddressHandler(private val addressService: AddressService) {

  fun findAddressByZipCode(request: ServerRequest): Mono<ServerResponse> {
    val zipcode = request.queryParam("zipcode").get()
    return ServerResponse.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body<Address>(addressService.findAddressByZipCode(zipcode))
  }

}