package com.eatexpress.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.eatexpress.app.*.*Application")
})

public class CompleteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompleteApplication.class, args);
    }
}
