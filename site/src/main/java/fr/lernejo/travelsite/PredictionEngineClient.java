package fr.lernejo.travelsite;

import fr.lernejo.travelsite.temperature.data.TemperatureResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PredictionEngineClient {
    @GET("/api/ping")
    Call<String> getPing();

    @GET("/api/temperature")
    Call<TemperatureResult> getTemperatures(@Query("country") String country);
}
