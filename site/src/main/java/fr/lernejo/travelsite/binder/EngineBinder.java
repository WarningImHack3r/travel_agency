package fr.lernejo.travelsite.binder;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class EngineBinder {

    public void fetchResultsFromBackend() throws IOException {
        // Load file in classpath
        new String(Objects.requireNonNull(getClass().getResourceAsStream("countries.txt")).readAllBytes(), StandardCharsets.UTF_8)
            .lines()//.forEach(
                // request backend
            /*)*/;
    }
}
