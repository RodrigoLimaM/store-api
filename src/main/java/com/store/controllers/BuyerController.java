package com.store.controllers;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.services.BuyerService;
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
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Buyer>> getBuyers() {
        return ResponseEntity.ok().body(buyerService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Buyer> getBuyerById(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(buyerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Buyer> saveBuyer(
            @Valid @RequestBody BuyerDTO requestBody) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/buyer"))
                .body(buyerService.save(requestBody));
    }
}
