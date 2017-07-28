package com.example.db.swagger.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.example.db.swagger.controller.MySwaggerTwoDemoController;

@ComponentScan(basePackages = { "com.example.db.swagger" }, basePackageClasses = { MySwaggerTwoDemoController.class })
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
public class SpringBootSwaggerDatabaseApplication {

    public static void main(String[] args) {

        System.out.println("Start");

        SpringApplication.run(SpringBootSwaggerDatabaseApplication.class, args);

        System.out.println("End");

    }
}
