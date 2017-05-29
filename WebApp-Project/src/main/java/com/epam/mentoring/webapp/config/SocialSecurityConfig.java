package com.epam.mentoring.webapp.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//@Configuration
//@EnableOAuth2Sso
public class SocialSecurityConfig /**extends WebSecurityConfigurerAdapter**/ {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/login**", "/webjars/**", "/index.html", "/home.html")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//        http.logout()
//                .permitAll()
////                .logoutUrl("/web-project/logout")
//                .logoutSuccessUrl("/").invalidateHttpSession(true);
//
//        http.csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//    }
}
