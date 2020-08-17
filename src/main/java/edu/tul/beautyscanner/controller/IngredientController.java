package edu.tul.beautyscanner.controller;

import edu.tul.beautyscanner.model.Ingredient;
import edu.tul.beautyscanner.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    //todo
    //dodac
    //usunac
    //update
    //wyswietlic wszystkie
    //wyswietlic wszystkie z allergenami

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/onlyAllergen")
    public ResponseEntity<List<Ingredient>> getAllAllergenicIngredients(){
        try {
            List<Ingredient> ingredients = ingredientRepository.findAllByAllergen();
            ingredients.sort(Comparator.comparing(Ingredient::getName));
            if(ingredients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
