package edu.tul.beautyscanner.controller;

import edu.tul.beautyscanner.model.Category;
import edu.tul.beautyscanner.model.Product;
import edu.tul.beautyscanner.repository.CategoryRepository;
import edu.tul.beautyscanner.repository.IngredientRepository;
import edu.tul.beautyscanner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    //todo
    //dodac
    //update
    //wyswietllic z alergenami

    private ProductRepository productRepository;
    private IngredientRepository ingredientRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, IngredientRepository ingredientRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            List<Product> products = productRepository.findAll();
            products.sort(Comparator.comparing(Product::getName));
            if(products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getAllProductsFromCategory(@PathVariable("category") Category category){
        List<Product> productsData = productRepository.findAllByCategory(category);

        if (!productsData.isEmpty()) {
            return new ResponseEntity<>(productsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/categoryId/{categoryId}")
//    public ResponseEntity<List<Product>> getAllProductsFromCategoryId(@PathVariable("categoryId") Long categoryId){
//        Optional<Category> categoryData = categoryRepository.findById(categoryId);
//
//        if (categoryData.isPresent()) {
//            List<Product> products = productRepository.findAllByCategory(categoryData.get());
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/categoryId/{categoryId}")
    public ResponseEntity<List<Product>> getAllProductsFromCategoryId(@PathVariable("categoryId") Long categoryId){
        List<Product> productsData = productRepository.findAllByCategoryId(categoryId);

        if (!productsData.isEmpty()) {
            return new ResponseEntity<>(productsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoryName/{categoryName}")
    public ResponseEntity<List<Product>> getAllProductsFromCategoryName(@PathVariable("categoryName") String categoryName){
        List<Product> productsData = productRepository.findAllByCategoryName(categoryName);

        if (!productsData.isEmpty()) {
            return new ResponseEntity<>(productsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Long productId) {
        try {
            productRepository.deleteById(productId);
            return new ResponseEntity<>("Delete successful of productID: "+productId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        Optional<Product> productData = productRepository.findById(productId);

        if (productData.isPresent()) {
            Product p = productData.get();
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setUrl(product.getUrl());
            p.setPicture(product.getPicture());
            return new ResponseEntity<>(productRepository.save(p), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
