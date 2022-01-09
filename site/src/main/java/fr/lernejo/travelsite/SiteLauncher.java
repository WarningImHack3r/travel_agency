package fr.lernejo.travelsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@SpringBootApplication
public class SiteLauncher {

    @Bean
    PredictionEngineClient predictionEngineClient() {
        return new Retrofit.Builder()
                   .baseUrl("http://localhost:7080/")
                   .addConverterFactory(JacksonConverterFactory.create())
                   .build()
                   .create(PredictionEngineClient.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SiteLauncher.class, args);
    }
}
