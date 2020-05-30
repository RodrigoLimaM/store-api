package com.store.services.impl;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.entities.mapper.ProductMapper;
import com.store.repositories.ProductRepository;
import com.store.services.ProductService;
import com.store.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    SalesmanService salesmanService;

    @Override
    public Product save(ProductDTO dto, Integer id) {
        return productRepository.save(productMapper.mapProductDTOToProduct(dto, salesmanService.findById(id)));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findProductByNameContainingIgnoreCase(name);
    }
}
