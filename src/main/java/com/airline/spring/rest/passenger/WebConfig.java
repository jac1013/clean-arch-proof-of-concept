package com.airline.spring.rest.passenger;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"com.airline.spring.rest.passenger"})
public class WebConfig extends WebMvcConfigurerAdapter {
}
