package com.store.services;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;

public interface SalesmanService {
    Salesman save(SalesmanDTO dto);
}
