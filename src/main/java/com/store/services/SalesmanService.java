package com.store.services;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;

import java.util.List;

public interface SalesmanService {
    Salesman save(SalesmanDTO dto);

    List<Salesman> findAll();

    Salesman findById(Integer id);
}
