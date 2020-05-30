package com.store.mapper;

import com.store.entities.Salesman;
import com.store.entities.dto.SalesmanDTO;
import com.store.entities.mapper.SalesmanMapper;
import org.apache.tomcat.jni.Local;
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
                987654321L,
                LocalDate.of(1990, 1, 1),
                "test@test.com",
                "12345678");

        SalesmanDTO newSalesmanDTO = new SalesmanDTO("teste",
                987654321L,
                "01/01/1990",
                "test@test.com",
                "12345678");

        Salesman actual = salesmanMapper.mapSalesmanDTOToSalesman(newSalesmanDTO);

        assertEquals(expected, actual);
    }

    @Test
    public void convertDate() {
        LocalDate expected = LocalDate.of(1990, 1, 1);

        LocalDate actual = salesmanMapper.convertDate("01/01/1990");

        assertEquals(expected, actual);
    }
}
