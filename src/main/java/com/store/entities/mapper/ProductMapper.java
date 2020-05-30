package com.store.entities.mapper;

import com.store.entities.Product;
import com.store.entities.Salesman;
import com.store.entities.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapProductDTOToProduct(ProductDTO dto, Salesman salesman) {
        return new Product(dto.getName(),
                dto.getQuantity(),
                dto.getPrice(),
                dto.getBrand(),
                dto.getDescription(),
                salesman);
    }
}
