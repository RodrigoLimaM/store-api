package com.store.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

@Table
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Buyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "buyer_name", nullable = false)
    @NonNull
    private String name;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @NonNull
    @Column(name = "buyer_cpf", nullable = false)
    private Long cpf;

    @NonNull
    @Column(name = "buyer_birth_date", nullable = false)
    private LocalDate birthDate;

    @NonNull
    @Column(name = "buyer_email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "buyer_password", nullable = false)
    private String password;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "buyer")
    private List<Purchases> purchases = new ArrayList<>();
}
