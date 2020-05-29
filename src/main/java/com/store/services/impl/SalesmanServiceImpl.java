package com.store.services.impl;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.entities.mapper.SalesmanMapper;
import com.store.repositories.SalesmanRepository;
import com.store.services.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    SalesmanMapper salesmanMapper;

    @Override
    public Salesman save(SalesmanDTO dto) {
        return salesmanRepository.save(salesmanMapper.mapSalesmanDTOToSalesman(dto));
    }
}
