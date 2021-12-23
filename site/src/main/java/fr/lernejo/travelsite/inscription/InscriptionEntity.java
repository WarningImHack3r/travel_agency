package fr.lernejo.travelsite.inscription;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Table("inscription")
public class InscriptionEntity {
    @Id
    public Long id;

    @NotNull
    @Email
    public String userEmail;

    @NotNull
    public String userName;

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$")
    public String userCountry;

    @NotNull
    @Enumerated(EnumType.STRING)
    public WeatherExpectations weatherExpectation;

    @NotNull
    @Min(0)
    @Max(39)
    public Integer minimumTemperatureDistance;
}
