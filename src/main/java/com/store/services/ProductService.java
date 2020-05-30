package com.store.services;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    Product save(ProductDTO dto, Integer id);

    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByName(String name);
}
