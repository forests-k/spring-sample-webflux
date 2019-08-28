package jp.co.musako.domain.service

import jp.co.musako.domain.entity.User
import jp.co.musako.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux

@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun findById(id: Int): Mono<User> = Mono.justOrEmpty(userRepository.findById(id))

    fun findAll(): Flux<User> = userRepository.findAll().toFlux()
}