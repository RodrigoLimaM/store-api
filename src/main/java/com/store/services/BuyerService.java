package com.store.services;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;

public interface BuyerService {
    Buyer save(BuyerDTO dto);
}
