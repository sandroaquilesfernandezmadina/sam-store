package org.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSamStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSamStoreApplication.class, args);
    }

}
