package com.lopushen;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpworkerApplication {

    @Value("${upworker.feed.prefix}")
    private String prefix;
    @Value("${upworker.feed.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(UpworkerApplication.class, args);
    }


}
