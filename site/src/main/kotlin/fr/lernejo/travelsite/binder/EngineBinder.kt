package fr.lernejo.travelsite.binder

import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets

@Service
class EngineBinder {

    fun fetchResultsFromBackend() {
        javaClass.classLoader.getResourceAsStream("countries.txt")?.readAllBytes()
            ?.let {
                // Load file in classpath
                String(it, StandardCharsets.UTF_8)
                    .lines().stream()
                    .forEach {
                        // request backend
                    }
            }
    }
}
