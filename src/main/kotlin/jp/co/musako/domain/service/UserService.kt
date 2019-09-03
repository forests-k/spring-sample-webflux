package jp.co.musako.domain.service

import jp.co.musako.domain.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux

@Service
class UserService(val userRepository: UserRepository) {

    fun findById(id: Int) = Mono.justOrEmpty(userRepository.findById(id))

    fun findAll() = userRepository.findAll().toFlux()
}