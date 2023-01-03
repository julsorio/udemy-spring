package com.udemy.spring.security.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.udemy.spring.security")
@PropertySource("classpath:postgre-datasource.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			dataSource.setUser(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.password"));
			
			dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
			dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
			dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
			dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		} catch (Exception e) {
			logger.error("Error al obtener jdbc properties");
		}
		
		return dataSource;
	}
}
