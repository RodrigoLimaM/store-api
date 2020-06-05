package com.store.controllers;

import com.store.entities.Buyer;
import com.store.entities.dto.UserDTO;
import com.store.services.BuyerService;
import com.store.services.authentication.UserAuthenticationService;
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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Buyer>> getBuyers() {
        return ResponseEntity.ok().body(buyerService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Buyer> getBuyerById(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(buyerService.findById(id));
    }

    @GetMapping(value = "/login", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isLoginValid(
            @RequestParam String email,
            @RequestParam String password) {
        return ResponseEntity.ok().body(userAuthenticationService.isBuyerLoginValid(email, password));
    }

    @PostMapping
    public ResponseEntity<Buyer> saveBuyer(
            @Valid @RequestBody UserDTO requestBody) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/buyer"))
                .body(buyerService.save(requestBody));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(
            @Valid @RequestBody UserDTO requestBody,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok().body(buyerService.update(requestBody, id));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Buyer> deleteBuyer(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(buyerService.deleteById(id));
    }
}
