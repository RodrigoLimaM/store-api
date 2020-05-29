package com.store.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Salesman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "salesman_name", nullable = false)
    @NonNull
    private String name;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @NonNull
    @Column(name = "salesman_cpf", nullable = false)
    private Long cpf;

    @NonNull
    @Column(name = "salesman_birth_date", nullable = false)
    private LocalDate birthDate;

    @NonNull
    @Column(name = "salesman_email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "salesman_password", nullable = false)
    private String password;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesman")
    private List<Product> products = new ArrayList<>();

}
