package jp.co.musako.domain.entity

import org.hibernate.annotations.*
import java.io.*
import java.time.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users_history")
data class UsersHistoryEntity(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  @Column(name = "user_id")
  val userId: Long,
  @Column(name = "mail")
  val mail: String,
  @Column(name = "gender")
  val gender: Int,
  @Column(name = "birthdate")
  val birthdate: LocalDate,
  @Column(name = "password")
  val password: String,
  @Column(name = "note")
  val note: String,
  @CreationTimestamp
  @Column(name = "created_at")
  val createdAt: LocalDateTime? = null
) : Serializable {
}