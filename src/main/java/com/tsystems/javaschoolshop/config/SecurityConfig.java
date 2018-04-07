package com.tsystems.javaschoolshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig class is the extension of provided by spring security
 * WebSecurityConfigAdapter. There we configure our http request rules
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Import(DataConfig.class)
@ComponentScan("com.tsystems.javaschoolshop")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Service which represents the implementation of spring's UserDetailsService interface.
     * And it provide us API for loading userDetails by email. And security module decides
     * if it should authorise such user using this userDetails object
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * There we register our implementation of UserDetailsService as instrument
     * for authentication.
     * @param authenticationMgr some AuthenticationManagerBuilder which spring provides us
     */
    @Autowired
    public void configureGlobalAuthentication(AuthenticationManagerBuilder authenticationMgr) {
        authenticationMgr.authenticationProvider(authProvider());
    }

    /**
     * There is overridden method where we secure our application by provided http parameter
     * @param http parameter provide us API for configuring all requests in application
     * @throws Exception in cases when we have some troubles during method processing
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/home/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_ANONYMOUS')")
                .antMatchers("/order").access("hasRole('ROLE_USER')")
                .and().formLogin().loginPage("/login").permitAll().usernameParameter("email")
                .passwordParameter("password").loginProcessingUrl("/account/user").failureUrl("/login.html?error=true").successForwardUrl("/account")
                .and()
                .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");

    }

    /**
     * Method register BCryptPasswordEncoder.
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Method authentication.
     * @return DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}
