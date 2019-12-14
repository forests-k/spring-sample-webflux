package jp.co.musako.domain.repository

import jp.co.musako.domain.entity.*
import org.springframework.data.jpa.repository.*

interface UserHistoryRepository : JpaRepository<UsersHistoryEntity, Long> {
}