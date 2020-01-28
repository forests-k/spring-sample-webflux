package jp.co.musako.config

import jp.co.musako.application.authentication.*
import jp.co.musako.domain.service.*
import org.springframework.context.annotation.*
import org.springframework.http.*
import org.springframework.security.authentication.*
import org.springframework.security.config.annotation.method.configuration.*
import org.springframework.security.config.annotation.web.reactive.*
import org.springframework.security.config.web.server.*
import org.springframework.security.crypto.password.*
import org.springframework.security.web.server.*
import org.springframework.security.web.server.authentication.*
import org.springframework.security.web.server.context.*
import org.springframework.security.web.server.util.matcher.*
import org.springframework.web.server.*

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(proxyTargetClass = true)
class WebSecurityConfig(
  private val passwordEncoder: PasswordEncoder,
  private val jsonBodyAuthenticationConverter: JsonBodyAuthenticationConverter,
  private val customServerAuthenticationEntryPoint: CustomServerAuthenticationEntryPoint,
  private val customServerAuthenticationSuccessHandler: CustomServerAuthenticationSuccessHandler,
  private val customServerAuthenticationFailureHandler: CustomServerAuthenticationFailureHandler,
  private val customReactiveUserDetailsService: CustomReactiveUserDetailsService
) {

  @Bean
  fun authenticationManager(): ReactiveAuthenticationManager {
    val authenticationManager = UserDetailsRepositoryReactiveAuthenticationManager(customReactiveUserDetailsService)
    authenticationManager.setPasswordEncoder(passwordEncoder)
    return authenticationManager
  }

  @Bean
  fun serverSecurityContextRepository(): ServerSecurityContextRepository {
    val repository = WebSessionServerSecurityContextRepository()
    repository.setSpringSecurityContextAttrName("securityContext")
    return repository
  }

  @Bean
  fun securityWebFilterChain(
    http: ServerHttpSecurity,
    authenticationManager: ReactiveAuthenticationManager,
    serverSecurityContextRepository: ServerSecurityContextRepository
  ): SecurityWebFilterChain {

    http.csrf { csrf ->
      csrf.disable()
    }

    http.authorizeExchange { exchanges ->
      exchanges.pathMatchers("/**").permitAll()
      exchanges.pathMatchers("/api/v1/**").permitAll()
      exchanges.pathMatchers("/api/v1/login").permitAll()
      exchanges.anyExchange().authenticated()
    }

    //http
    //  .formLogin()
    //  .loginPage("/api/v1/login")

    http
      .logout()
      .logoutUrl("/api/v1/logout")

    http
      .httpBasic()
      .disable()

    http.addFilterAt(
      authenticationWebFilter(authenticationManager, serverSecurityContextRepository),
      SecurityWebFiltersOrder.AUTHENTICATION
    )

    http.exceptionHandling()
      .authenticationEntryPoint(customServerAuthenticationEntryPoint)

    return http.build()
  }

  fun authenticationWebFilter(
    authenticationManager: ReactiveAuthenticationManager,
    serverSecurityContextRepository: ServerSecurityContextRepository
  ): WebFilter {
    return AuthenticationWebFilter(authenticationManager).apply {
      // 認証処理を行うリクエスト
      setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/api/v1/login"))
      // 認証処理における認証情報を抽出方法
      setServerAuthenticationConverter(jsonBodyAuthenticationConverter)
      // 認証成功/失敗時の処理
      setAuthenticationSuccessHandler(customServerAuthenticationSuccessHandler)
      setAuthenticationFailureHandler(customServerAuthenticationFailureHandler)
      // セキュリティコンテキストの保存方法
      setSecurityContextRepository(serverSecurityContextRepository)
    }
  }
}

