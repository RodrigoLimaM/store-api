package com.store.mapper;

import com.store.entities.Buyer;
import com.store.entities.dto.UserDTO;
import com.store.entities.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void mapBuyerDTOToBuyer() {
        Buyer expected = new Buyer("teste",
                "89085288061",
                LocalDate.of(1990, 1, 1),
                "test@test.com",
                "12345678");

        UserDTO newBuyerDTO = new UserDTO("teste",
                "89085288061",
                "01/01/1990",
                "test@test.com",
                "12345678");

        Buyer actual = userMapper.mapBuyerDTOToBuyer(newBuyerDTO);

        assertEquals(expected, actual);
    }
}
