package fr.lernejo.travelsite.inscription;

public enum WeatherExpectations {
    WARMER("WARMER"),
    COLDER("COLDER");

    private final String value;

    WeatherExpectations(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
