package com.springboot.example.startinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n ApplicationRunner called at startup");
        Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
    }
}