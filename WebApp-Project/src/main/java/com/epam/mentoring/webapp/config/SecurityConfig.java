package com.epam.mentoring.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and();

        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login**", "/webjars/**", "/index.html", "/home.html", "/about.html", "/contact.html")
                .permitAll()
                .anyRequest()
                .authenticated().and();

        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
//                .failureUrl("/login?error=1")
                .usernameParameter("username").passwordParameter("password")
                .permitAll().and();

        http.logout().permitAll().and();

        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("tatyana").password("tatyana222").roles("USER");
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
    }
}
