package com.store.entities.mapper;

import com.store.entities.Buyer;
import com.store.entities.Salesman;
import com.store.entities.dto.UserDTO;
import com.store.services.utils.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    DateConversionService dateConversionService;

    public Buyer mapBuyerDTOToBuyer(UserDTO dto) {
        return new Buyer(dto.getName(),
                dto.getCpf(),
                dateConversionService.convertDate(dto.getBirthDate()),
                dto.getEmail(),
                dto.getPassword());
    }

    public Salesman mapSalesmanDTOToSalesman(UserDTO dto){
        return new Salesman(dto.getName(),
                dto.getCpf(),
                dateConversionService.convertDate(dto.getBirthDate()),
                dto.getEmail(),
                dto.getPassword());
    }
}
