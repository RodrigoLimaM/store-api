package com.store.services.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DateConversionServiceTest {

    @Autowired
    DateConversionService dateConversionService;

    @Test
    public void convertDate() {
        LocalDate expected = LocalDate.of(1990, 1, 1);

        LocalDate actual = dateConversionService.convertDate("01/01/1990");

        assertEquals(expected, actual);
    }
}
