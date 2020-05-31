package com.store.services.impl;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.entities.mapper.BuyerMapper;
import com.store.repositories.BuyerRepository;
import com.store.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(Integer id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public Buyer deleteById(Integer id) {
        Buyer deletedBuyer = this.findById(id);
        buyerRepository.deleteById(id);
        return deletedBuyer;
    }
}
