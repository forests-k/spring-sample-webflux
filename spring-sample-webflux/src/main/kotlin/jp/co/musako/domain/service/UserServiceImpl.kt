package jp.co.musako.domain.service

import jp.co.musako.domain.entity.*
import jp.co.musako.domain.model.*
import jp.co.musako.domain.repository.*
import jp.co.musako.domain.type.*
import org.springframework.security.crypto.password.*
import org.springframework.stereotype.*
import reactor.core.publisher.*
import javax.transaction.*

@Service
class UserServiceImpl(
  private val userRepository: UserRepository,
  private val userHistoryRepository: UserHistoryRepository,
  private val passwordEncoder: PasswordEncoder
) : UserService {

  override fun findById(id: Long): Mono<User> =
    Mono.justOrEmpty(userRepository.findById(id).map { users -> users.convertToUser() })

  override fun findAll(): Flux<User> =
    Flux.fromIterable(userRepository.findAll().toList().map { users -> users.convertToUser() })

  @Transactional
  override fun create(signUpUser: SignUpUser): Mono<User> {
    val currentUser = userRepository.save(
      UsersEntity(
        mail = signUpUser.mail!!,
        gender = signUpUser.gender!!,
        password = passwordEncoder.encode(signUpUser.password),
        birthdate = signUpUser.birthdate!!
      )
    )

    // 変更履歴を登録
    userHistoryRepository.save(
      UsersHistoryEntity(
        userId = currentUser.id!!,
        mail = currentUser.mail,
        gender = currentUser.gender,
        birthdate = currentUser.birthdate,
        password = currentUser.password,
        note = Note.CREATE.type
      )
    )
    return Mono.just(currentUser.convertToUser())
  }

  @Transactional
  override fun update(id: Long, monoUser: Mono<User>): Mono<User> {
    val currentUser = userRepository.findById(id).orElseThrow { IllegalArgumentException() }

    // 変更内容を登録
    monoUser.subscribe { user ->
      currentUser.mail = user.mail
      currentUser.gender = user.gender
      currentUser.birthdate = user.birthdate
    }
    userRepository.save(currentUser)

    // 変更履歴を登録
    userHistoryRepository.save(
      UsersHistoryEntity(
        userId = currentUser.id!!,
        mail = currentUser.mail,
        gender = currentUser.gender,
        birthdate = currentUser.birthdate,
        password = currentUser.password,
        note = Note.UPDATE.type
      )
    )

    return Mono.just(currentUser.convertToUser())
  }

  @Transactional
  override fun delete(id: Long) {
    val currentUser = userRepository.findById(id).orElseThrow { IllegalArgumentException() }

    // 変更履歴を登録
    userHistoryRepository.save(
      UsersHistoryEntity(
        userId = currentUser.id!!,
        mail = currentUser.mail,
        gender = currentUser.gender,
        birthdate = currentUser.birthdate,
        password = currentUser.password,
        note = Note.DELETE.type
      )
    )
    userRepository.deleteById(id)
  }
}