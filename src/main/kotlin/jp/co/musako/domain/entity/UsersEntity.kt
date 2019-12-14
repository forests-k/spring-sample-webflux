package jp.co.musako.domain.entity

import jp.co.musako.domain.model.*
import java.io.*
import java.time.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class UsersEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "mail")
        var mail: String,

        @Column(name = "gender")
        var gender: Int,

        @Column(name = "password")
        var password: String,

        @Column(name = "birthdate")
        var birthdate: LocalDate,

        @Column(name = "create_user_id")
        var createUserId: Long,

        @Column(name = "create_timestamp")
        var createTimestamp: LocalDateTime
) : Serializable {

    fun convertToUser() = User(
            id = id,
            mail = mail,
            gender = gender,
            birthdate = birthdate,
            createUserId = createUserId,
            createTimestamp = createTimestamp
    )
}