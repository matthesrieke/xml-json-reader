package org.n52.datareader.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.n52.datareader"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
