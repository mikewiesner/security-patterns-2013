package com.mwiesner.sp.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses=OrderRestController.class)
@EnableWebMvc
@ImportResource("classpath:marshaller.xml")
public class SpringWebMvcConfig {

}
