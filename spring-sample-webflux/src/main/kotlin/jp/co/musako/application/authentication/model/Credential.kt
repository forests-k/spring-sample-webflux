package jp.co.musako.application.authentication.model

import com.fasterxml.jackson.annotation.*
import org.springframework.security.authentication.*

data class Credential(
  @JsonProperty("username")
  val username: String,
  val password: String
) {
  fun toToken() = UsernamePasswordAuthenticationToken(username, password)
}
