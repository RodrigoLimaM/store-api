package com.store.services;

import com.store.entities.Salesman;
import com.store.entities.dto.UserDTO;

import java.util.List;

public interface SalesmanService {
    Salesman save(UserDTO dto);

    List<Salesman> findAll();

    Salesman findById(Integer id);

    Salesman update(UserDTO dto, Integer id);

    Salesman deleteById(Integer id);
}
