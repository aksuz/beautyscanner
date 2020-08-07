package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
