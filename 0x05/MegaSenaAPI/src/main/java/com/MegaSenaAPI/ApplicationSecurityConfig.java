package com.MegaSenaAPI;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http
       .httpBasic()
       .and()
       .authorizeRequests()
       .antMatchers("/h2-console/**").permitAll()
       .antMatchers("/").permitAll()
       .antMatchers("/getNumbers").hasRole("ADMIN")
       .and()
       .csrf().disable()
       .headers().frameOptions().disable();   
   }
   
   @Override
   protected void configure(AuthenticationManagerBuilder builder) throws Exception {
       builder
               .userDetailsService(userDetailsService())
               .passwordEncoder(new BCryptPasswordEncoder());
   }
}   
