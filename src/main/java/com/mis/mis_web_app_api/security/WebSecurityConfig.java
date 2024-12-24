package com.mis.mis_web_app_api.security;

import com.mis.mis_web_app_api.security.jwt.AuthEntryPointJwt;
import com.mis.mis_web_app_api.security.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig {

    public WebSecurityConfig(AuthEntryPointJwt unauthorizedHandler) {
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("""
                http://your-frontend-url.com""")); // Update with the appropriate frontend URL
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/oauth/token",
                                "/api/public/**",
                                "/openapi/**").permitAll()
                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .permitAll())

                // Manually configure CSRF handling
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for stateless APIs (like JWT)

                // Manually configure CORS
                .cors(cors -> cors
                        .configurationSource(corsConfigurationSource()));

        // Add JWT authentication filter before the UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
