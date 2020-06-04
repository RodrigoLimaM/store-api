package com.store.services.impl;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.entities.mapper.BuyerMapper;
import com.store.exception.InvalidPasswordException;
import com.store.exception.NoDataFoundException;
import com.store.repositories.BuyerRepository;
import com.store.services.BuyerService;
import com.store.services.utils.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    BuyerMapper buyerMapper;

    @Autowired
    DateConversionService dateConversionService;

    @Override
    public Buyer save(BuyerDTO dto) {
        if (dto.getPassword().length() < 8)
            throw new InvalidPasswordException();
        return buyerRepository.save(buyerMapper.mapBuyerDTOToBuyer(dto));
    }

    @Override
    public List<Buyer> findAll() {
        var response = buyerRepository.findAll();
        if (response.isEmpty())
            throw new NoDataFoundException();
        return response;
    }

    @Override
    public Buyer findById(Integer id) {
        return buyerRepository.findById(id).orElseThrow(() -> new NoDataFoundException());
    }

    @Override
    public Buyer deleteById(Integer id) {
        Buyer deletedBuyer = this.findById(id);
        buyerRepository.deleteById(id);
        return deletedBuyer;
    }

    @Override
    public Buyer update(BuyerDTO dto, Integer id) {
        Buyer actual = this.findById(id);
        Buyer updatedBuyer = updateBuyerFields(dto, actual);

        return buyerRepository.save(updatedBuyer);
    }

    private Buyer updateBuyerFields(BuyerDTO dto, Buyer actual) {
        actual.setName(dto.getName());
        actual.setBirthDate(dateConversionService.convertDate(dto.getBirthDate()));
        actual.setCpf(dto.getCpf());
        actual.setEmail(dto.getEmail());
        actual.setPassword(dto.getPassword());

        return actual;
    }
}
