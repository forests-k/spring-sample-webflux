package jp.co.musako.application.authentication.model

import jp.co.musako.domain.entity.*
import org.springframework.security.core.*
import org.springframework.security.core.userdetails.*
import java.io.*

class CustomUserDetails(
  private val user: UsersEntity,
  private val authorities: List<GrantedAuthority>
) : User(
  user.mail,
  user.password,
  authorities
), Serializable {
}