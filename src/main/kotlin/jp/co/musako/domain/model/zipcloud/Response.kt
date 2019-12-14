package jp.co.musako.domain.model.zipcloud

import jp.co.musako.domain.model.*
import java.util.*

data class Response(
        val status: Int,

        val message: String? = null,

        val results: List<Address> = Collections.emptyList()
) {
}