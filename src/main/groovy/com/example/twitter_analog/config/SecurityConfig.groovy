package com.example.twitter_analog.config

import com.example.twitter_analog.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Autowired
    private UserService userService

    @Autowired
    private PasswordEncoder passwordEncoder

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/")
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().disable()
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder()
    }
}
