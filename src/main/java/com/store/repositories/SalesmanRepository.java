package com.store.repositories;

import com.store.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Integer> {
}
