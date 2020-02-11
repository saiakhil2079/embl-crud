package com.embl.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/retrieve").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/store").hasRole("ADMIN").antMatchers(HttpMethod.DELETE, "/delete/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.POST, "/update").hasRole("ADMIN").and().csrf().disable()
				.formLogin().disable();

		http.headers().frameOptions().sameOrigin();

	}

}
