package com.example.demo.config;

import com.example.demo.service.registry.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 1. Добавляем корень "/" в список разрешенных!
                        .requestMatchers("/", "/error", "/api/main", "/api/auth/**", "/favicon.ico").permitAll()

                        // 2. Разрешаем статику и иконку (браузеры очень её любят)
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // 3. Админка
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/api/auth/login")         // Страница, где лежит HTML
                        .loginProcessingUrl("/api/auth/login") // URL, который обрабатывает POST (такой же)
                        .defaultSuccessUrl("/api/main", true)          // Куда летим после успеха
                        .permitAll()                           // Еще раз разрешаем всем доступ к логину
                )
                .logout(logout -> logout
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessUrl("/api/main")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


}
