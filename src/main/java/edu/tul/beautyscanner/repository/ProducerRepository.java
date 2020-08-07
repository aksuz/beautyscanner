package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
