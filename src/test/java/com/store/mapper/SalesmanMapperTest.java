package com.store.mapper;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.entities.mapper.SalesmanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SalesmanMapperTest {

    @Autowired
    SalesmanMapper salesmanMapper;

    @Test
    public void mapSalesmanDTOToSalesman() {
        Salesman expected = new Salesman("teste",
                "89085288061",
                LocalDate.of(1990, 1, 1),
                "test@test.com",
                "12345678");

        SalesmanDTO newSalesmanDTO = new SalesmanDTO("teste",
                "89085288061",
                "01/01/1990",
                "test@test.com",
                "12345678");

        Salesman actual = salesmanMapper.mapSalesmanDTOToSalesman(newSalesmanDTO);

        assertEquals(expected, actual);
    }
}
