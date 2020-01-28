package jp.co.musako.domain.service

import jp.co.musako.application.authentication.model.*
import jp.co.musako.domain.repository.*
import org.springframework.security.core.authority.*
import org.springframework.security.core.userdetails.*
import org.springframework.stereotype.*
import reactor.core.publisher.*

@Service
class CustomReactiveUserDetailsServiceImpl(
  private val userRepository: UserRepository
) : CustomReactiveUserDetailsService {

  override fun findByUsername(username: String): Mono<UserDetails> {
    val userEntity = userRepository.findByMail(username)
    if (userEntity.isEmpty) return Mono.empty()
    return Mono.just(CustomUserDetails(userEntity.get(), arrayListOf(SimpleGrantedAuthority("USER"))))
  }
}