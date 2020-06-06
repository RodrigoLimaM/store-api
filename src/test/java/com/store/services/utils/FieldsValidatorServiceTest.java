package com.store.services.utils;

import com.store.exception.InvalidCPFException;
import com.store.exception.InvalidDateException;
import com.store.exception.InvalidEmailException;
import com.store.exception.InvalidPasswordException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FieldsValidatorServiceTest {

    @Autowired
    FieldsValidatorService fieldsValidatorService;

    @Test
    public void dateValidator() {
        LocalDate minorBirthDate = LocalDate.now().minusYears(18).plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        assertTrue(fieldsValidatorService.dateValidator("10/02/2000"));
        assertThrows(InvalidDateException.class, () -> fieldsValidatorService.dateValidator("32/07/2000"));
        assertThrows(InvalidDateException.class, () -> fieldsValidatorService.dateValidator("10/13/2000"));
        assertThrows(InvalidDateException.class, () -> fieldsValidatorService.dateValidator(minorBirthDate.format(formatter)));
    }

    @Test
    public void emailValidator() {
        assertTrue(fieldsValidatorService.emailValidator("digo100200@gmail.com"));
        assertThrows(InvalidEmailException.class, () -> fieldsValidatorService.emailValidator("emailemail.com"));
        assertThrows(InvalidEmailException.class, () -> fieldsValidatorService.emailValidator("ema@ile@mail.com"));
        assertThrows(InvalidEmailException.class, () -> fieldsValidatorService.emailValidator("émail@email.com"));
        assertThrows(InvalidEmailException.class, () -> fieldsValidatorService.emailValidator("email@"));
    }

    @Test
    public void passwordValidator() {
        assertTrue(fieldsValidatorService.passwordValidator("12345678"));
        assertThrows(InvalidPasswordException.class, () -> fieldsValidatorService.passwordValidator("1234567"));
    }

    @Test
    public void cpfValidator(){
        assertTrue(fieldsValidatorService.cpfValidator("04747444009"));
        assertThrows(InvalidCPFException.class, () -> fieldsValidatorService.cpfValidator("12345678987"));
    }
}
