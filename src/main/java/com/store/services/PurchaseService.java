package com.store.services;

import com.store.entities.Purchase;

public interface PurchaseService {
    Purchase save(Integer buyerId, Integer productId, Integer quantity);
}
