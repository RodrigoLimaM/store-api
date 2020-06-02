package com.store.controllers;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.services.SalesmanService;
import com.store.services.authentication.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/salesman")
public class SalesmanController {

    @Autowired
    SalesmanService salesmanService;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Salesman>> getSalesmans() {
        List<Salesman> response = salesmanService.findAll();
        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Salesman> getSalesmanById(
            @PathVariable Integer id) {
        Salesman response = salesmanService.findById(id);
        return response == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/login", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isLoginValid(
            @RequestParam String email,
            @RequestParam String password) {
        return ResponseEntity.ok().body(userAuthenticationService.isSalesmanLoginValid(email, password));
    }

    @PostMapping
    public ResponseEntity<Salesman> saveSalesman(
            @Valid @RequestBody SalesmanDTO requestBody) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/salesman"))
                .body(salesmanService.save(requestBody));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salesman> updateSalesman(
            @Valid @RequestBody SalesmanDTO requestBody,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok().body(salesmanService.update(requestBody, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Salesman> deleteSalesman(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(salesmanService.deleteById(id));
    }

}
