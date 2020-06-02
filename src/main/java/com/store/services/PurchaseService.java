package com.store.services;

import com.store.entities.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase save(Integer buyerId, Integer productId, Integer quantity);

    List<Purchase> findAll();
}
