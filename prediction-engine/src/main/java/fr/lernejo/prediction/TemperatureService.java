package fr.lernejo.prediction;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TemperatureService {

    private final Map<CaseInsensitiveString, TemperatureGenerationData> temperatureDatasByCountry;
    private final Random random = new Random();

    TemperatureService() {
        temperatureDatasByCountry = new ClassPathFileLoader().readLines("countriesTempData.csv")
                                        .skip(1)
                                        .map(TemperatureGenerationData::parseCsv)
                                        .collect(Collectors.toMap(v -> new CaseInsensitiveString(v.country()), Function.identity()));
    }

    public double getTemperature(String country) throws UnknownCountryException {
        TemperatureGenerationData data = temperatureDatasByCountry.get(new CaseInsensitiveString(country));
        if (data == null) {
            throw new UnknownCountryException(country);
        }
        return generateBelievableTemperature(data);
    }

    private double generateBelievableTemperature(@NotNull TemperatureGenerationData data) {
        DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        int avg = data.avg();
        double delta = ((double) random.nextInt(data.variance() * 2 * 100)) / 100 - data.variance();
        return Double.parseDouble(df.format(avg + delta));
    }

    record TemperatureGenerationData(String country, int avg, int variance) {
        @Contract("_ -> new")
        public static @NotNull TemperatureGenerationData parseCsv(@NotNull String csvLine) {
            String[] split = csvLine.split(";");
            return new TemperatureGenerationData(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
    }

    record CaseInsensitiveString(String value) {
        @Override
        public int hashCode() {
            return value == null ? 0 : Objects.hash(value.toLowerCase(Locale.ROOT));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return Objects.equals(value.toLowerCase(Locale.ROOT), ((CaseInsensitiveString) o).value.toLowerCase(Locale.ROOT));
        }
    }
}
