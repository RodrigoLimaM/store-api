package com.store.controllers;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Salesman>> getSalesmans() {
        return ResponseEntity.ok().body(salesmanService.findAll());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Salesman> getSalesmanById(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(salesmanService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Salesman> saveSalesman(
            @Valid @RequestBody SalesmanDTO dto) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/salesman"))
                .body(salesmanService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salesman> updateSalesman(
            @Valid @RequestBody SalesmanDTO dto,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok().body(salesmanService.update(dto, id));
    }

}
