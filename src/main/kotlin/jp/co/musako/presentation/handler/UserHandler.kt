package jp.co.musako.presentation.handler

import jp.co.musako.domain.entity.User
import jp.co.musako.domain.service.UserService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class UserHandler(private val userService: UserService) {

    fun findAll(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body<User>(userService.findAll())

    fun findById(request: ServerRequest): Mono<ServerResponse> {
        val id: Int = Integer.parseInt(request.pathVariable("id"))
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body<User>(userService.findById(id))
    }

}