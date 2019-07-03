package com.itacademy.database.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.itacademy.database.util")
@Import(DataBaseConfig.class)
public class TestConfig {
}
