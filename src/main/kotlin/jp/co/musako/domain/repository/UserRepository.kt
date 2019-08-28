package jp.co.musako.domain.repository

import jp.co.musako.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Int> {

    fun findByMail(mailAddress: String): Optional<User>
}