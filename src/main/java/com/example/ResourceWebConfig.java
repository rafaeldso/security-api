package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.controllers.OrderController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses= {OrderController.class})
public class ResourceWebConfig extends WebMvcConfigurerAdapter {}