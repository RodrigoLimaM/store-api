package com.store.services;

import com.store.entities.Buyer;
import com.store.entities.dto.UserDTO;

import java.util.List;

public interface BuyerService {
    Buyer save(UserDTO dto);

    List<Buyer> findAll();

    Buyer findById(Integer id);

    Buyer deleteById(Integer id);

    Buyer update(UserDTO dto, Integer id);
}
