package com.store.entities.dto;

import com.store.entities.Salesman;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDTO implements Serializable {

    private Integer id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private BigDecimal price;

    @NotBlank
    @NotNull
    private String brand;

    @NotBlank
    @NotNull
    private String description;

    private Salesman salesman;
}
