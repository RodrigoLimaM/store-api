package com.store.services.utils;

import com.store.entities.dto.ToValidateFieldsDTO;
import com.store.exception.InvalidCPFException;
import com.store.exception.InvalidDateException;
import com.store.exception.InvalidEmailException;
import com.store.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.Period;

@Service
public class FieldsValidatorService {

    @Autowired
    DateConversionService dateConversionService;

    public Boolean isFieldsValid(ToValidateFieldsDTO dto) {
        return passwordValidator(dto.getPassword())
                && cpfValidator(dto.getCpf())
                && emailValidator(dto.getEmail())
                && dateValidator(dto.getBirthDate());
    }

    boolean dateValidator(String date) {
        String[] dateArr = date.split("/");
        Integer[] integerDateFields = stringToInt(dateArr);
        if (integerDateFields[0] > 31 || integerDateFields[1] > 12 || !ageValidator(date))
            throw new InvalidDateException();
        return true;
    }

    boolean ageValidator(String date) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateConversionService.convertDate(date), currentDate).getYears();
        return age > 17;
    }

    private Integer[] stringToInt(String[] dateArr) {
        Integer[] intDateFields = new Integer[3];
        for (int i = 0; i < 3; i++)
            intDateFields[i] = Integer.parseInt(dateArr[i]);

        return intDateFields;
    }

    boolean emailValidator(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e) {
            throw new InvalidEmailException();
        }
        return true;
    }

    boolean passwordValidator(String password) {
        if (password.length() < 8)
            throw new InvalidPasswordException();
        return true;
    }

    boolean cpfValidator(String cpf) {
        int sum = 0;
        int mod;

        if (cpf.equals("00000000000") || cpf.length() != 11)
            throw new InvalidCPFException();

        for (int i = 1; i <= 9; i++)
            sum += Integer.parseInt(cpf.substring(i-1, i)) * (11 - i);

        mod = (sum * 10) % 11;


        if((mod == 10) || (mod == 1))
            mod = 0;

        if (mod != Integer.parseInt(cpf.substring(9, 10)))
            throw new InvalidCPFException();

        sum = 0;

        for (int i = 1; i <= 10; i++)
            sum += Integer.parseInt(cpf.substring(i-1, i)) * (12 - i);

        mod = (sum * 10) % 11;

        if((mod == 10) || (mod == 1))
            mod = 0;

        if (mod != Integer.parseInt(cpf.substring(10, 11)))
            throw new InvalidCPFException();

        return true;
    }
}
