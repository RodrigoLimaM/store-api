package com.store.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties("salesman")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "product_name", nullable = false)
    private String name;



    @NonNull
    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @NonNull
    @Column(name = "product_brand", nullable = false)
    private String brand;

    @NonNull
    @Column(name = "product_description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "salesman_id")
    @NonNull
    private Salesman salesman;
}
