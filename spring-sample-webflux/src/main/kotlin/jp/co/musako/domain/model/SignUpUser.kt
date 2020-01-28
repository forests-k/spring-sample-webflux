package jp.co.musako.domain.model

import java.io.*
import java.time.*
import javax.validation.constraints.*

data class SignUpUser(
  @field: NotBlank val mail: String?,
  @field: NotBlank val gender: Int?,
  @field: NotBlank val birthdate: LocalDate?,
  @field: NotBlank val password: String?
) : Serializable
