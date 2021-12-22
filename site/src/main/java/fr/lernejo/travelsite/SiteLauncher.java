package fr.lernejo.travelsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SiteLauncher {

    public static void main(String[] args) {
        SpringApplication.run(SiteLauncher.class, args);
    }
}
