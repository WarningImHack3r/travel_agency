package fr.lernejo.travelsite.inscription;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends CrudRepository<InscriptionEntity, Long> {}
