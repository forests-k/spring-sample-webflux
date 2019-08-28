package jp.co.musako.domain.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "foodstuff_nutrient")
class FoodstuffNutrient(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        @Column(name = "foodstuff_id")
        val foodstuffId: Int,

        @Column(name = "nutrient_id")
        val nutrientId: Int,

        @Column(name = "wight_by_type")
        val wightByType: String,

        @Column(name = "create_user_id")
        val createUserId: Int,

        @Column(name = "create_timestamp")
        val createTimestamp: LocalDateTime,

        @Column(name = "update_user_id")
        val updateUserId: Int,

        @Column(name = "update_timestamp")
        val updateTimestamp: LocalDateTime
) : Serializable {
}