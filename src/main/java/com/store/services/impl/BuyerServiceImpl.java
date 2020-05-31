package com.store.services.impl;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.entities.mapper.BuyerMapper;
import com.store.repositories.BuyerRepository;
import com.store.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    BuyerMapper buyerMapper;

    @Override
    public Buyer save(BuyerDTO dto) {
        return buyerRepository.save(buyerMapper.mapBuyerDTOToBuyer(dto));
    }
}
