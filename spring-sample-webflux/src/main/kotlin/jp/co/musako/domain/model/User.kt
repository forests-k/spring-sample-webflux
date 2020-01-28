package jp.co.musako.domain.model

import java.io.*
import java.time.*

data class User(
  var id: Long? = null,
  val mail: String,
  val gender: Int,
  val birthdate: LocalDate,
  var createdAt: LocalDateTime? = null
) : Serializable {
}