package com.store.controllers;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @PostMapping
    public ResponseEntity<Buyer> saveBuyer(
            @Valid @RequestBody BuyerDTO requestBody) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/buyer"))
                .body(buyerService.save(requestBody));
    }
}
