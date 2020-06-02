package com.store.services.authentication;

import com.store.repositories.BuyerRepository;
import com.store.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserAuthenticationService {

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    BuyerRepository buyerRepository;

    public Boolean isSalesmanLoginValid(String email, String password) {
        return !salesmanRepository
                .findAll()
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .filter(s -> s.getPassword().equals(password))
                .collect(Collectors.toList()).isEmpty();
    }

    public Boolean isBuyerLoginValid(String email, String password) {
        return !buyerRepository
                .findAll()
                .stream()
                .filter(s -> s.getEmail().equals(email))
                .filter(s -> s.getPassword().equals(password))
                .collect(Collectors.toList()).isEmpty();
    }
}
