package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT i FROM Ingredient i WHERE i.isAllergen = true ")
    List<Ingredient> findAllByAllergen();
}
