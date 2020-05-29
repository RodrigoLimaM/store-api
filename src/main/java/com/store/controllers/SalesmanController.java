package com.store.controllers;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.services.SalesmanService;
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
@RequestMapping(value = "/salesman")
public class SalesmanController {

    @Autowired
    SalesmanService salesmanService;

    @PostMapping
    public ResponseEntity<Salesman> saveSalesman(
            @Valid @RequestBody SalesmanDTO dto) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/salesman" +dto.getId()))
                .body(salesmanService.save(dto));
    }
}
