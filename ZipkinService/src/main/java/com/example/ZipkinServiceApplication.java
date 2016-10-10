package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceApplication.class, args);
    }
}
