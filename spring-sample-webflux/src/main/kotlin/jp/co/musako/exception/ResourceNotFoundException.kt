package jp.co.musako.exception

import org.springframework.http.*

class ResourceNotFoundException(val httpStatusCode: HttpStatus, msg: String? = null) : RuntimeException(msg) {
}