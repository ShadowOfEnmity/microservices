package by.javaguru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigAppServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAppServer.class, args);
    }
}
