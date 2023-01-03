package com.udemy.spring.config;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.udemy.spring.coach.Coach;
import com.udemy.spring.coach.TeamCoach;
import com.udemy.spring.servicios.FortuneService;
import com.udemy.spring.servicios.SadFortuneServiceImpl;
import com.udemy.spring.servicios.TeamFortuneService;
import com.udemy.spring.sport.BowlingCoach;
import com.udemy.spring.sport.SoccerCoach;
import com.udemy.spring.sport.SwimCoach;

@Configuration
//@ComponentScan("com.udemy.spring.*")
//@PropertySource("classpath:mylogger.properties")
@PropertySources({ @PropertySource("classpath:mylogger.properties"), @PropertySource("classpath:sport.properties") })
public class AppConfig {
	@Value("${root.logger}")
	private String rootLoggerLevel;

	@Value("${printed.logger.level}")
	private String printedLoggerLevel;

	@PostConstruct
	public void initLogger() {
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printedLevel = Level.parse(printedLoggerLevel);

		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		Logger loggerParent = applicationContextLogger.getParent();

		loggerParent.setLevel(rootLevel);

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());

		loggerParent.addHandler(consoleHandler);
	}

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneServiceImpl();
	}

	@Bean
	public FortuneService teamFortuneService() {
		return new TeamFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach(sadFortuneService());
		return swimCoach;
	}

	@Bean
	public SoccerCoach soccerCoach() {
		SoccerCoach soccerCoach = new SoccerCoach();
		return soccerCoach;
	}

	@Bean
	public TeamCoach bowlingCoach() {
		BowlingCoach bowlingCoach = new BowlingCoach(teamFortuneService());
		return bowlingCoach;
	}
}
