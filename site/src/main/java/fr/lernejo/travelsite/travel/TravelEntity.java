package fr.lernejo.travelsite.travel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("travel")
public class TravelEntity {
    @Id
    public Long id;
}
