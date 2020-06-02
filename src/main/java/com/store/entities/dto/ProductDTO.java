package com.store.entities.dto;

import io.swagger.annotations.ApiModelProperty;
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

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "Playstation 3")
    private String name;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "3")
    private Integer quantity;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "820.00")
    private BigDecimal price;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "Sony")
    private String brand;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "Pouco usado")
    private String description;
}
