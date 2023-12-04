package ru.tinkoff.fintech.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.tinkoff.fintech.qa")
@ConfigurationPropertiesScan("ru.tinkoff.fintech.qa")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
