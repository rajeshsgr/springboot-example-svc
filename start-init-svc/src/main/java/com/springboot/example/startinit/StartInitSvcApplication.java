package com.springboot.example.startinit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartInitSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartInitSvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            System.out.println("\n In CommandLineRunnerImpl in the main class");

            for (String arg : args) {
                System.out.println(arg);
            }
        };
    }

}
