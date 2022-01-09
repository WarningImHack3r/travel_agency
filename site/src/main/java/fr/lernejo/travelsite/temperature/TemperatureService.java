package fr.lernejo.travelsite.temperature;

import fr.lernejo.travelsite.PredictionEngineClient;
import fr.lernejo.travelsite.temperature.data.TemperatureResult;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public record TemperatureService(PredictionEngineClient predictionEngineClient) {

    public TemperatureResult getTemperatures(String country) {
        try {
            return predictionEngineClient.getTemperatures(country).execute().body();
        } catch (IOException e) {
            System.err.println("Error with country " + country  + ": " + e.getLocalizedMessage());
            return null;
        }
    }
}
