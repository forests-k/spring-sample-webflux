package jp.co.musako.domain.repository

import jp.co.musako.domain.entity.Foodstuff
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodstuffRepository : JpaRepository<Foodstuff, Int> {
}