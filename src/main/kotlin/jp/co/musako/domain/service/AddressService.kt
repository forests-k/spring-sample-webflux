package jp.co.musako.domain.service

import jp.co.musako.domain.model.*
import jp.co.musako.domain.model.zipcloud.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.client.*
import reactor.core.publisher.*
import java.util.*

@Service
class AddressService {

    @Value("\${address.url}")
    val url: String = ""

    @Value("\${address.limit}")
    val limit: Int? = 1

    fun findAddressByZipCode(zipcode: String): Flux<Address> {

        var client = WebClient.builder().build()
        //var latch = CountDownLatch(1)

        var response: Mono<Response> = client.get().uri(url).retrieve().bodyToMono(Response::class.java)
        //latch.await()

        var addresses = ArrayList<Address>()
        response.map { r -> addresses.addAll(r.results) }
        return Flux.fromIterable(addresses)
    }
}