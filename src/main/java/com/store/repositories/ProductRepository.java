package com.store.repositories;

import com.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByNameContainingIgnoreCase(String name);
}
