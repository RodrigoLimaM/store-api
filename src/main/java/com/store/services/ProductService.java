package com.store.services;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;

public interface ProductService {

    Product save(ProductDTO dto, Integer id);
}
