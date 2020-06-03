package com.store.services.impl;

import com.store.entities.Buyer;
import com.store.entities.Product;
import com.store.entities.Purchase;
import com.store.repositories.PurchaseRepository;
import com.store.services.BuyerService;
import com.store.services.ProductService;
import com.store.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    ProductService productService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public Purchase save(Integer buyerId, Integer productId, Integer purchasedQuantity) {
        Purchase purchase = buildPurchase(buyerId, productId, purchasedQuantity);
        productService.updateQuantity(productId, purchasedQuantity);
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase findById(Integer id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    private Purchase buildPurchase(Integer buyerId, Integer productId, Integer purchasedQuantity) {
        Product purchasedProduct = productService.findById(productId);
        Buyer buyer = buyerService.findById(buyerId);
        return new Purchase(purchasedProduct.getName(),
                purchasedProduct.getBrand(),
                purchasedQuantity,
                purchasedProduct.getPrice(),
                purchasedProduct.getPrice().multiply(BigDecimal.valueOf(purchasedQuantity)),
                purchasedProduct.getSalesman(),
                buyer);
    }
}
