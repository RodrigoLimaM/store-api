package com.store.mapper;

import com.store.entities.Product;
import com.store.entities.Salesman;
import com.store.entities.dto.ProductDTO;
import com.store.entities.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void mapProductDTOToProduct() {
        Product expected = new Product("Teste", 3, new BigDecimal(1000.00),"teste", "teste teste", new Salesman());

        ProductDTO newProductDTO = new ProductDTO("Teste", 3, new BigDecimal(1000.00), "teste", "teste teste");

        Product actual = productMapper.mapProductDTOToProduct(newProductDTO, new Salesman());

        assertEquals(expected, actual);
    }

}
