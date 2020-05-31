package com.store.repositories;

import com.store.entities.Product;
import com.store.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByNameContainingIgnoreCase(String name);

    @Transactional
    void deleteBySalesman(Salesman salesman);
}
