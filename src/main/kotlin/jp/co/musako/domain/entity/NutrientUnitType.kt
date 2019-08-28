package jp.co.musako.domain.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "nutrient_unit_type")
class NutrientUnitType(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        @Column(name = "nutrient_unit_type_name")
        val nutrient_unit_type_name: String,

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