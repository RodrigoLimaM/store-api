package com.store.entities.mapper;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.services.utils.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesmanMapper {

    @Autowired
    DateConversionService dateConversionService;

    public Salesman mapSalesmanDTOToSalesman(SalesmanDTO dto){
        return new Salesman(dto.getName(),
                    dto.getCpf(),
                    dateConversionService.convertDate(dto.getBirthDate()),
                    dto.getEmail(),
                    dto.getPassword());
    }

}
