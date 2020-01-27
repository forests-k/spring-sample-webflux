package jp.co.musako.domain.model

import java.io.*
import java.time.*

data class User(
  var id: Long? = null,
  var mail: String,
  var gender: Int,
  var birthdate: LocalDate,
  var createTimestamp: LocalDateTime? = null
) : Serializable {
}