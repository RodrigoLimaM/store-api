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
import java.math.BigDecimal;

@Table
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    @NonNull
    @Column(name = "product_name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "product_brand", nullable = false)
    private String brand;

    @NonNull
    @Column(name = "product_quantity", nullable = false)
    private Integer purchasedQuantity;

    @NonNull
    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @NonNull
    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @ManyToOne
    @JoinColumn(name = "salesman_id")
    @NonNull
    @JsonIgnoreProperties({"creationDate", "updateDate", "birthDate", "email", "password", "products"})
    private Salesman salesman;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @NonNull
    @JsonIgnoreProperties({"creationDate", "updateDate", "birthDate", "email", "password", "purchases"})
    private Buyer buyer;
}
