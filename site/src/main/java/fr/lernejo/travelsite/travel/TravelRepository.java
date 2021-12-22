package fr.lernejo.travelsite.travel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends CrudRepository<TravelEntity, Long> {}
