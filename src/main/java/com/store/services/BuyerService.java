package com.store.services;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;

import java.util.List;

public interface BuyerService {
    Buyer save(BuyerDTO dto);

    List<Buyer> findAll();

    Buyer findById(Integer id);

    Buyer deleteById(Integer id);

    Buyer update(BuyerDTO dto, Integer id);
}
