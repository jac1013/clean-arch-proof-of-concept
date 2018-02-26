package com.airline.spring.rest.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScans({@ComponentScan("com.airline.spring.database"), @ComponentScan("com.airline.spring.rest.passenger")})
@EntityScan("com.airline.spring.database")
@EnableJpaRepositories("com.airline.spring.database")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
