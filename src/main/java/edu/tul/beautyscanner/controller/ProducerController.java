package edu.tul.beautyscanner.controller;

import edu.tul.beautyscanner.model.Producer;
import edu.tul.beautyscanner.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {

    private ProducerRepository producerRepository;

    @Autowired
    public ProducerController(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Producer>> getAllProducers(){
        try {
            List<Producer> categories = producerRepository.findAll();
            categories.sort(Comparator.comparing(Producer::getName));
            if(categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getTutorialById(@PathVariable("id") Long id) {
        Optional<Producer> producerData = producerRepository.findById(id);

        if (producerData.isPresent()) {
            return new ResponseEntity<>(producerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Producer> addCategory(@RequestBody Producer producer) {
        try {
            producerRepository.save(producer);
            Producer p = new Producer().builder()
                    .id(producer.getId())
                    .name(producer.getName())
                    .countryId(producer.getCountryId())
                    .build();
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producer> updateTutorial(@PathVariable("id") Long id, @RequestBody Producer producer) {
        Optional<Producer> producerData = producerRepository.findById(id);

        if (producerData.isPresent()) {
            Producer p = producerData.get();
            p.setName(producer.getName());
            p.setCountryId(producer.getCountryId());
            return new ResponseEntity<>(producerRepository.save(p), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //todo Cannot delete or update a parent row: a foreign key constraint fails (`beautyscanner`.`product`, CONSTRAINT `FK1yixfxyh2fyr3yqdq3bwa5c7v` FOREIGN KEY (`producer_id_producer`) REFERENCES `producer` (`id_producer`))
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long id) {
        try {
            producerRepository.deleteById(id);
            return new ResponseEntity<>("Deleted CategoryID: "+id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllCategories() {
        try {
            producerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //todo SPRING JPA operacje kaskadowe - usuwanie producenta = usuniecie produktów tego producenta
    }
}
