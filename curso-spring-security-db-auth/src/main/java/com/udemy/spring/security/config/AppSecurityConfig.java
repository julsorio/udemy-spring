package com.udemy.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/employees").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER").antMatchers("/systems/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and()
				.logout().logoutSuccessUrl("/").permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-denied");

	}

}