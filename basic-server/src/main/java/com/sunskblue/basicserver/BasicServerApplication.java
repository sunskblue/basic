package com.sunskblue.basicserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BasicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicServerApplication.class, args);
    }

}
