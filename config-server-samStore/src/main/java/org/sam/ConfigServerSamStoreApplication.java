package org.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerSamStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerSamStoreApplication.class, args);
    }

}
