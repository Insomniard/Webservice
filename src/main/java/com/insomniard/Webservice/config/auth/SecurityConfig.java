package com.insomniard.Webservice.config.auth;

import com.insomniard.Webservice.Account.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/assets/**","/login/**","/loginBoard","/f").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .antMatchers("/api/v1/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login().loginPage("/loginBoard")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
