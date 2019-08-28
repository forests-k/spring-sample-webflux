package jp.co.musako.presentation.router

import jp.co.musako.presentation.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.web.reactive.function.server.router

@Configuration
class UserRouter(private val userHandler: UserHandler) {

    @Bean
    fun uuserRouter() = router {
        accept(APPLICATION_JSON_UTF8).nest {
            GET("/user", userHandler::findAll)
            GET("/user/{id}", userHandler::findById)
        }
    }
}