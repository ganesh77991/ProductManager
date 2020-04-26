package com.product.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Spring boot security configuration class.
@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/formProduct").hasRole("USER")
		.antMatchers("/customers").hasRole("ADMIN")
		.and().formLogin().and().logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}user123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
	}
}