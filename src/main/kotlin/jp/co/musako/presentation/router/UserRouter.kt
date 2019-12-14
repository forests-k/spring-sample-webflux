package jp.co.musako.presentation.router

import jp.co.musako.presentation.handler.*
import org.springframework.context.annotation.*
import org.springframework.http.*
import org.springframework.web.reactive.function.server.*

@Configuration
@ComponentScan
class UserRouter(private val userHandler: UserHandler) {

    @Bean
    fun apiRouter() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/users", userHandler::findAll)
            GET("/users/{id}", userHandler::findById)
            POST("/users", userHandler::create)
            PUT("/users/{id}", userHandler::update)
            DELETE("/users/{id}", userHandler::delete)
        }
    }
}