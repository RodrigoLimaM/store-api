package com.store.entities.mapper;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    SalesmanService salesmanService;

    public Product mapProductDTOToProduct(ProductDTO dto, Integer id) {
        return new Product(dto.getName(),
                dto.getPrice(),
                dto.getBrand(),
                dto.getDescription(),
                salesmanService.findById(id));
    }
}
