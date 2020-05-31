package com.store.controllers;

import com.store.entities.Purchase;
import com.store.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/{buyerId}/{productId}/quantity")
    public ResponseEntity<Purchase> purchase(
            @PathVariable Integer buyerId,
            @PathVariable Integer productId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok().body(purchaseService.save(buyerId, productId, quantity));
    }

}
