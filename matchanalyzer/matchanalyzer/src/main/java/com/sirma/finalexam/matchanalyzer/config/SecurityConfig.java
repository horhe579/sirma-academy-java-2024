package com.sirma.finalexam.matchanalyzer.config;

import com.sirma.finalexam.matchanalyzer.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(AuthenticationProvider authenticationProvider,
                          JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**", "/")
                        .permitAll() // Allows public access to certain endpoints
                        //.requestMatchers("/players/")
                        //.hasAuthority("ROLE_MANAGER")
                        .requestMatchers(HttpMethod.GET, "/matches", "/players", "/teams", "/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/matches").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/matches/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/matches/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/players").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/players/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/players/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/teams").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/teams/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/teams/**").hasAuthority("ADMIN")
                        .anyRequest()
                        .authenticated() // Requires authentication for all other requests
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:5009"));
        configuration.setAllowedMethods(List.of("GET","POST"));
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }
}
