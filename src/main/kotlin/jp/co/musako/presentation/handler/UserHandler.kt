package jp.co.musako.presentation.handler

import jp.co.musako.domain.entity.*
import jp.co.musako.domain.model.*
import jp.co.musako.domain.service.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.*
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.*

@Component
class UserHandler(private val userService: UserService) {

    fun findAll(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body<User>(userService.findAll())

    fun findById(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body<User>(userService.findById(request.pathVariable("id").toLong()))

    fun create(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(UsersEntity::class.java)
                    .flatMap { user ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(userService.create(user))
                    }.switchIfEmpty(ServerResponse.badRequest().build())

    fun update(request: ServerRequest): Mono<ServerResponse> {

        val body = request.body(BodyExtractors.toMono(UsersEntity::class.java))
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.update(request.pathVariable("id").toLong(), body))
                .switchIfEmpty(ServerResponse.badRequest().build())
    }

    /**
    request.bodyToMono<UsersEntity>()
    .flatMap { user ->
    ServerResponse.ok()
    .contentType(MediaType.APPLICATION_JSON)
    .body(userService.update(request.pathVariable("id").toLong(), user))
    }.switchIfEmpty(ServerResponse.badRequest().build())
     */

    fun delete(request: ServerRequest): Mono<ServerResponse> {
        userService.delete(request.pathVariable("id").toLong())
        return ServerResponse.ok().build()
    }


}