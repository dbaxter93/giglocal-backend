package com.giglocal.GigLocalAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class OAuth2ResourceServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .authorizeRequests()
                .antMatchers("/save_gig").anonymous();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://959928-ee-giglocal.s3-website-us-west-2.amazonaws.com"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE"));
        configuration.setAllowCredentials(true);
        // the below three lines will add the relevant CORS response headers
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
