package jp.co.musako.domain.model

import java.io.*
import java.time.*

data class User(
        var id: Long? = null,
        var mail: String? = null,
        var gender: Int? = null,
        var birthdate: LocalDate? = null,
        var createUserId: Long? = null,
        var createTimestamp: LocalDateTime? = null
) : Serializable {
}