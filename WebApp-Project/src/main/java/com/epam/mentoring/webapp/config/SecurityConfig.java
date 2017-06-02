package com.epam.mentoring.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
// To use Facebook OAuth2 login the @EnableOAuth2Sso added
// behavior: now digits (user id?) are displayed in case of Facebook login
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and();

        http.authorizeRequests()
                .antMatchers("/login**", "/webjars/**", "/index.html", "/home.html", "/about.html", "/contact.html",
                        "/registration.html", "/user-profile.html", "/users")
                .permitAll()
                .antMatchers("/users-list.html").hasRole("ADMIN")
                .anyRequest()
                .authenticated().and();

        http.formLogin()
                .loginPage("/")
                .usernameParameter("username").passwordParameter("password")
                .permitAll().and();

        http.logout().permitAll().and();

        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }
}
