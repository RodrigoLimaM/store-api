package com.store.entities;

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
import java.math.BigDecimal;

@Table
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "product_name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "product_quantity", nullable = false)
    private Integer quantity;

    @NonNull
    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @NonNull
    @Column(name = "product_brand", nullable = false)
    private String brand;

    @NonNull
    @Column(name = "salesman_name", nullable = false)
    private String salesmanName;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @NonNull
    private Buyer buyer;
}
