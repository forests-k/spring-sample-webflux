package jp.co.musako.exception

import org.springframework.http.HttpStatus

class ResourceNotFoundException(val httpStatusCode: HttpStatus, msg: String? = null) : RuntimeException(msg) {
}