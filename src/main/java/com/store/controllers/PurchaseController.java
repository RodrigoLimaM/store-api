package com.store.controllers;

import com.store.entities.Purchase;
import com.store.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Purchase>> getPurchases() {
        List<Purchase> response = purchaseService.findAll();
        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Purchase> getPurchase(
            @PathVariable Integer id) {
        Purchase response = purchaseService.findById(id);
        return response == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(response);
    }

    @PostMapping("/{buyerId}/{productId}/quantity")
    public ResponseEntity<Purchase> purchase(
            @PathVariable Integer buyerId,
            @PathVariable Integer productId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok().body(purchaseService.save(buyerId, productId, quantity));
    }

}
