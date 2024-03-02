package com.example.gestaoescolar.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class WebSecurityConfig {

        @Bean
        public BCryptPasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

        private static final String[] SWAGGER_WHITELIST = {
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "configuration/ui",
                "configuration/security",
                "swagger-ui.html",
                "/webjars/**"

        };

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();
            http.cors().and().csrf().disable()
                    .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .requestMatchers(SWAGGER_WHITELIST).permitAll()
                    .requestMatchers("/h2-console/**").permitAll()
                    .requestMatchers( "/gestaoescolar/professor/cadastrarprofessor").permitAll()
                    .requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/professor/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/professor/listarprofessores").permitAll()
                    .requestMatchers(HttpMethod.POST, "/gestaoescolar/aula/novaaula").hasAnyRole("PROFESSOR")
                    .requestMatchers(HttpMethod.DELETE, "/gestaoescolar/aula/**").hasAnyRole("PROFESSOR")
                    .requestMatchers(HttpMethod.POST, "/gestaoescolar/matricula/novamatricula").permitAll()
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/matricula/**").hasAnyRole("PROFESSOR","ESTUDANTE")
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/matricula/listarmatriculas").hasAnyRole("PROFESSOR")
                    .requestMatchers(HttpMethod.POST, "/gestaoescolar/notas/lancarnota").hasAnyRole("PROFESSOR")
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/notas/**").hasAnyRole("PROFESSOR","ESTUDANTE")
                    .requestMatchers(HttpMethod.GET, "/gestaoescolar/notas/listarnotas").hasAnyRole("PROFESSOR")
                    .anyRequest().authenticated()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            return http.build();
        }


    }
