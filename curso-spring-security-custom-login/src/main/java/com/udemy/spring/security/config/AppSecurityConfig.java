package com.udemy.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in memory authentication

		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(userBuilder.username("mary").password("test123").roles("MANAGER"))
				.withUser(userBuilder.username("susan").password("test123").roles("ADMIN"));

		/*
		 * auth.inMemoryAuthentication().withUser("john").password("test123").roles(
		 * "EMPLOYEE");
		 * auth.inMemoryAuthentication().withUser("mary").password("test123").roles(
		 * "MANAGER");
		 * auth.inMemoryAuthentication().withUser("susan").password("test123").roles(
		 * "ADMIN");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/loginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll();
	}

}