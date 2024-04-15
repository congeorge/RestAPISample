package com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestApiSampleApplication {

    public static void main(String[] args) {

      //  System.setProperty("javax.net.debug", "all");
        SpringApplication.run(RestApiSampleApplication.class, args);
    }

}
