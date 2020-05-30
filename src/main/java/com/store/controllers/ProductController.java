package com.store.controllers;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<Product> saveProduct(
            @Valid @RequestBody ProductDTO dto, @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/product/" +id))
                .body(productService.save(dto, id));
    }

}
