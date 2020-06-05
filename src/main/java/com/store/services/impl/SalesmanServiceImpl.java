package com.store.services.impl;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.entities.dto.ToValidateFieldsDTO;
import com.store.entities.mapper.SalesmanMapper;
import com.store.exception.InvalidPasswordException;
import com.store.exception.NoDataFoundException;
import com.store.repositories.ProductRepository;
import com.store.repositories.SalesmanRepository;
import com.store.services.SalesmanService;
import com.store.services.utils.DateConversionService;
import com.store.services.utils.FieldsValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SalesmanMapper salesmanMapper;

    @Autowired
    DateConversionService dateConversionService;

    @Autowired
    FieldsValidatorService fieldsValidatorService;

    @Override
    public Salesman save(SalesmanDTO dto) {
        fieldsValidatorService.isFieldsValid(ToValidateFieldsDTO
                .builder()
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
        return salesmanRepository.save(salesmanMapper.mapSalesmanDTOToSalesman(dto));
    }

    @Override
    public List<Salesman> findAll() {
        var response = salesmanRepository.findAll();
        if (response.isEmpty())
            throw new NoDataFoundException();
        return response;
    }

    @Override
    public Salesman findById(Integer id) {
        return salesmanRepository.findById(id).orElseThrow(() -> new NoDataFoundException());
    }

    @Override
    public Salesman update(SalesmanDTO dto, Integer id) {
        Salesman actual = this.findById(id);
        Salesman updatedSalesman = updateSalesmanFields(dto, actual);

        return salesmanRepository.save(updatedSalesman);
    }

    @Override
    public Salesman deleteById(Integer id) {
        Salesman deletedSalesman = this.findById(id);
        productRepository.deleteBySalesman(deletedSalesman);
        return deletedSalesman;
    }

    private Salesman updateSalesmanFields(SalesmanDTO dto, Salesman actual) {
        actual.setName(dto.getName());
        actual.setCpf(dto.getCpf());
        actual.setBirthDate(dateConversionService.convertDate(dto.getBirthDate()));
        actual.setEmail(dto.getEmail());
        actual.setPassword(dto.getPassword());

        return actual;
    }
}
