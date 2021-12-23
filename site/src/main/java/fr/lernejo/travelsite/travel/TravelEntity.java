package fr.lernejo.travelsite.travel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Table("travel")
public class TravelEntity {
    @Id
    public Long id;

    @NotNull
    public String country;

    @NotNull
    public Number temperature;
}
