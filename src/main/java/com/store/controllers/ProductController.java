package com.store.controllers;

import com.store.entities.Product;
import com.store.entities.dto.ProductDTO;
import com.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Product> response = productService.findAll();
        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(
            @PathVariable Integer id) {
        Product response = productService.findById(id);
        return response == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @GetMapping(value ="/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findProductByName(
            @RequestParam String name) {
        List<Product> response = productService.findByName(name);
        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> saveProduct(
            @Valid @RequestBody ProductDTO requestBody,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/product/" +id))
                .body(productService.save(requestBody, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id,
            @RequestBody ProductDTO requestBody) {
        return ResponseEntity.ok().body(productService.update(id, requestBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(productService.deleteById(id));
    }

}
