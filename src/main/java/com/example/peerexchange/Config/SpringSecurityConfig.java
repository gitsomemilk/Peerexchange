package com.example.peerexchange.Config;


import com.example.peerexchange.Filter.JwtRequestFilter;
import com.example.peerexchange.Services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    /*inject customUserDetailService en jwtRequestFilter*/
    private CustomUserDetailsService customUserDetailsService;
    private JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                /*voeg de antmatchers toe voor admin(post en delete) en user (overige)*/

                .antMatchers(HttpMethod.POST,"/assignments").hasRole("STUDENT")
                .antMatchers(HttpMethod.POST,"/class").hasRole("TEACHER")
                .antMatchers(HttpMethod.POST,"/review").hasRole("TEACHER")
                .antMatchers(HttpMethod.POST,"/review").hasRole("STUDENT")
                .antMatchers(HttpMethod.POST,"/submission").hasRole("STUDENT")
                .antMatchers(HttpMethod.POST,"/submission").hasRole("TEACHER")

                .antMatchers(HttpMethod.GET,"/assignments/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET,"/assignments/{id}").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET,"/review/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET,"/review/{id}").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET,"/class/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET,"/class/{id}").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET,"/submission/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET,"/submission/{id}").hasRole("STUDENT")

                .antMatchers(HttpMethod.DELETE,"/assignments/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.DELETE,"/assignments/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/class/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.DELETE,"/class/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/review/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.DELETE,"/review/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/submission/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.DELETE,"/submission/**").hasRole("ADMIN")

                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()/*allen dit punt mag toegankelijk zijn voor niet ingelogde gebruikers*/
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}