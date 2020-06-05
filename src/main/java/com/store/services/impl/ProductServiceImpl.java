package com.store.services.impl;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.entities.mapper.ProductMapper;
import com.store.exception.NoDataFoundException;
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
        var response = productRepository.findAll();
        if (response.isEmpty())
            throw new NoDataFoundException();
        return response;
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public List<Product> findByName(String name) {
        var response = productRepository.findProductByNameContainingIgnoreCase(name);
        if (response.isEmpty())
            throw new NoDataFoundException();
        return response;
    }

    @Override
    public Product deleteById(Integer id) {
        Product deletedProduct = this.findById(id);
        productRepository.deleteById(id);
        return deletedProduct;
    }

    @Override
    public Product update(Integer id, ProductDTO dto) {
        Product actual = this.findById(id);
        Product updatedProduct = updateProductFields(dto, actual);
        return productRepository.save(updatedProduct);
    }

    @Override
    public void updateQuantity(Integer productId, Integer quantity) {
        Product updatedProduct = this.findById(productId);
        updatedProduct.setQuantity(updatedProduct.getQuantity() - quantity);
        productRepository.save(updatedProduct);
    }

    private Product updateProductFields(ProductDTO dto, Product actual) {
        actual.setName(dto.getName());
        actual.setBrand(dto.getBrand());
        actual.setDescription(dto.getDescription());
        actual.setPrice(dto.getPrice());
        actual.setQuantity(dto.getQuantity());

        return actual;
    }
}
