package com.springboot.example.startinit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n CommandLineRunner called at startup");
        Arrays.stream(args).forEach(System.out::println);
    }
}