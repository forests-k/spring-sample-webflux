package jp.co.musako.application.authentication.model

import com.fasterxml.jackson.annotation.*
import org.springframework.security.authentication.*

data class Credential(
  @JsonProperty("mail")
  val mailAddress: String,
  val password: String
) {
  fun toToken() = UsernamePasswordAuthenticationToken(mailAddress, password)
}
