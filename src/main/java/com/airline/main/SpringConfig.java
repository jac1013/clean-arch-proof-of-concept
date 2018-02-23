package com.airline.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({"com.airline.database"})
@EntityScan({"com.airline.database"})
public class SpringConfig {
}
