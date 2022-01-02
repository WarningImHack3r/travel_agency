package fr.lernejo.travelsite;

import fr.lernejo.travelsite.retrofit.PredictionEngineClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SiteLauncher {

    @Bean
    PredictionEngineClient predictionEngineClient() {
        return new Retrofit.Builder()
                   .baseUrl("http://localhost:7080/")
                   .build()
                   .create(PredictionEngineClient.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SiteLauncher.class, args);
    }
}
