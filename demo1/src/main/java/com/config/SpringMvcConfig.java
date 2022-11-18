package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName SpringMvcConfig
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 9:37
 * @Version 1.0
 */

@Configuration
@ComponentScan(basePackages = {"com.controller"})
@EnableWebMvc
public class SpringMvcConfig {

}
