package jp.co.musako.domain.repository

import jp.co.musako.domain.entity.Nutrient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NutrientRepository : JpaRepository<Nutrient, Int> {
}