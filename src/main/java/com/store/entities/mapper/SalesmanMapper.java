package com.store.entities.mapper;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SalesmanMapper {

    public Salesman mapSalesmanDTOToSalesman(SalesmanDTO dto){
        return new Salesman(dto.getName(),
                    dto.getCpf(),
                    convertDate(dto.getBirthDate()),
                    dto.getEmail(),
                    dto.getPassword());
    }

    public LocalDate convertDate(String date) {
        String[] yearMonthDay = date.split("/");
        return LocalDate.of( stringToInt(yearMonthDay[2]) ,
                stringToInt(yearMonthDay[1]),
                stringToInt(yearMonthDay[0]));
    }

    public Integer stringToInt(String field){
        return Integer.parseInt(field);
    }
}
