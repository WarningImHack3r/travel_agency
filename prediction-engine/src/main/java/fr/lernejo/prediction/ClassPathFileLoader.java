package fr.lernejo.prediction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class ClassPathFileLoader {

    public Stream<String> readLines(String classPath) {
        InputStream resource = TemperatureService.class.getClassLoader().getResourceAsStream(classPath);
        if (resource == null) {
            throw new IllegalArgumentException("No file named " + classPath + " in classPath");
        }
        try {
            return new String(resource.readAllBytes(), StandardCharsets.UTF_8).lines();
        } catch (IOException e) {
            // surely dead code
            throw new IllegalStateException("valid resource URL should be readable");
        }
    }
}
