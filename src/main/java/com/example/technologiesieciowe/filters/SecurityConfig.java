package com.example.technologiesieciowe.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${jwt.token.key}")
    private String key;

    /**
     * Filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)

                .sessionManagement(httpSecuritySessionManagementConfigurer -> {
                    httpSecuritySessionManagementConfigurer
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                }).addFilterBefore(new JWTTokenFilter(key), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                //.requestMatchers("/user/**").hasRole("Librarian")
                                .requestMatchers(HttpMethod.OPTIONS).permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/book/getById").hasRole("LIBRARIAN")
                                .requestMatchers("/getAllBooks").hasRole("User")
                                .requestMatchers("/book/test").hasRole("LIBRARIAN")
                                .requestMatchers("/user/getAll").hasRole("LIBRARIAN")
                                .requestMatchers("/book/delete").hasRole("LIBRARIAN")
                                .requestMatchers("/**").permitAll())
                //W konfiguracji nie używamy prefiksu ROLE_
                .build();

    }
}
