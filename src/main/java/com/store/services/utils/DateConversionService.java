package com.store.services.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateConversionService {

    public LocalDate convertDate(String date) {
        String[] yearMonthDay = date.split("/");
        return LocalDate.of( stringToInt(yearMonthDay[2]) ,
                stringToInt(yearMonthDay[1]),
                stringToInt(yearMonthDay[0]));
    }

    private Integer stringToInt(String field){
        return Integer.parseInt(field);
    }
}
