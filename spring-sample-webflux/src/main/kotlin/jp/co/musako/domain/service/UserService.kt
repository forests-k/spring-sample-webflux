package jp.co.musako.domain.service

import jp.co.musako.domain.model.*
import reactor.core.publisher.*

interface UserService {

  fun findById(id: Long): Mono<User>

  fun findAll(): Flux<User>

  fun create(signUpUser: SignUpUser): Mono<User>

  fun update(id: Long, monoUser: Mono<User>): Mono<User>

  fun delete(id: Long)
}