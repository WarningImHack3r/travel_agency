package fr.lernejo.travelsite.temperature;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.List;

@Table("temperature")
public class TemperatureEntity {
    @Id
    public Long id;

    @NotNull
    public String country;

    @NotNull
    public List<TemperatureItem> temperatures;
}
