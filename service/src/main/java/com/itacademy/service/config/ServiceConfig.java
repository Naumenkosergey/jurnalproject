package com.itacademy.service.config;

import com.itacademy.database.config.DataBaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.itacademy.service")
@Import(DataBaseConfig.class)
public class ServiceConfig {


}
