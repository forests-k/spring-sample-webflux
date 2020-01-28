package jp.co.musako.domain.entity

import jp.co.musako.domain.model.*
import org.hibernate.annotations.*
import java.io.*
import java.time.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UsersEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  @Column(name = "mail")
  var mail: String,
  @Column(name = "gender")
  var gender: Int,
  @Column(name = "password")
  val password: String,
  @Column(name = "birthdate")
  var birthdate: LocalDate,
  @Column(name = "created_at")
  @CreationTimestamp
  val createdAt: LocalDateTime? = null
) : Serializable {

  fun convertToUser() = User(
    id = id,
    mail = mail,
    gender = gender,
    birthdate = birthdate,
    createdAt = createdAt
  )
}