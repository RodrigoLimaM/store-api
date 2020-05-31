package com.store.mapper;

import com.store.entities.Buyer;
import com.store.entities.dto.BuyerDTO;
import com.store.entities.mapper.BuyerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BuyerMapperTest {

    @Autowired
    BuyerMapper buyerMapper;

    @Test
    public void mapBuyerDTOToBuyer() {
        Buyer expected = new Buyer("teste",
                987654321L,
                LocalDate.of(1990, 1, 1),
                "test@test.com",
                "12345678");

        BuyerDTO newBuyerDTO = new BuyerDTO("teste",
                987654321L,
                "01/01/1990",
                "test@test.com",
                "12345678");

        Buyer actual = buyerMapper.mapBuyerDTOToBuyer(newBuyerDTO);

        assertEquals(expected, actual);
    }
}
