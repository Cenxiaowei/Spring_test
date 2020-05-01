package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by cxw15 on 2020/4/24.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApplication {

    public static void main(String[] args){

        SpringApplication.run(ServerApplication.class,args);
    }
}
