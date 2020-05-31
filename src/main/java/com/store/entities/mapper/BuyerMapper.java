package com.store.entities.mapper;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.services.utils.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuyerMapper {

    @Autowired
    DateConversionService dateConversionService;

    public Buyer mapBuyerDTOToBuyer(BuyerDTO dto) {
        return new Buyer(dto.getName(),
                dto.getCpf(),
                dateConversionService.convertDate(dto.getBirthDate()),
                dto.getEmail(),
                dto.getPassword());
    }
}
