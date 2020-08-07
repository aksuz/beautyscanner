package edu.tul.beautyscanner.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository pr;

    @Test
    void test() {
        pr.findAllByCategory("KREM");
    }
}