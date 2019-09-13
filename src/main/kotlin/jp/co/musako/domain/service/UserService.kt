package jp.co.musako.domain.service

import jp.co.musako.domain.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {

    fun findById(id: Int) = Mono.justOrEmpty(userRepository.findById(id))

    fun findAll() = Flux.fromIterable(userRepository.findAll())
}