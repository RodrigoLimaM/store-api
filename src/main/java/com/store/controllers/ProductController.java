package com.store.controllers;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Product> saveProduct(
            @Valid @RequestBody ProductDTO dto, @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/product/" +id))
                .body(productService.save(dto, id));
    }

}
