package jp.co.musako.domain.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "foodstuff")
data class Foodstuff(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,

        @Column(name = "name")
        val name: String,

        @Column(name = "unit_type_id")
        val unitTypeId: Int,

        @Column(name = "foodstuff_group")
        val foodstuffGroup: String,

        @Column(name = "food_number")
        val foodNumber: String,

        @Column(name = "foodstuff_index_number")
        val foodstuffIndexNumber: String,

        @Column(name = "note")
        val note: String,

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