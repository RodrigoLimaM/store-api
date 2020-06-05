package com.store.services.impl;

import com.store.entities.Buyer;
import com.store.entities.dto.ToValidateFieldsDTO;
import com.store.entities.dto.UserDTO;
import com.store.entities.mapper.UserMapper;
import com.store.exception.NoDataFoundException;
import com.store.repositories.BuyerRepository;
import com.store.services.BuyerService;
import com.store.services.utils.DateConversionService;
import com.store.services.utils.FieldsValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DateConversionService dateConversionService;

    @Autowired
    FieldsValidatorService fieldsValidatorService;

    @Override
    public Buyer save(UserDTO dto) {
        dtoFieldsValidation(dto);
        return buyerRepository.save(userMapper.mapBuyerDTOToBuyer(dto));
    }

    private void dtoFieldsValidation(UserDTO dto) {
        fieldsValidatorService.isFieldsValid(ToValidateFieldsDTO
                .builder()
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
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
        return buyerRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public Buyer deleteById(Integer id) {
        Buyer deletedBuyer = this.findById(id);
        buyerRepository.deleteById(id);
        return deletedBuyer;
    }

    @Override
    public Buyer update(UserDTO dto, Integer id) {
        fieldsValidatorService.isFieldsValid(ToValidateFieldsDTO
                .builder()
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
        Buyer actual = this.findById(id);
        Buyer updatedBuyer = updateBuyerFields(dto, actual);

        return buyerRepository.save(updatedBuyer);
    }

    private Buyer updateBuyerFields(UserDTO dto, Buyer actual) {
        actual.setName(dto.getName());
        actual.setBirthDate(dateConversionService.convertDate(dto.getBirthDate()));
        actual.setCpf(dto.getCpf());
        actual.setEmail(dto.getEmail());
        actual.setPassword(dto.getPassword());

        return actual;
    }
}
