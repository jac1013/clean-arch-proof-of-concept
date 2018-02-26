package com.airline.spring.rest.passenger;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.airline.spring.database")
@EntityScan("com.airline.spring.database")
@EnableJpaRepositories("com.airline.spring.database")
public class AppConfig {
}
