package com.store.entities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SalesmanDTO implements Serializable {

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "Renato Andrade")
    private String name;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "97564027735")
    private Long cpf;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "07/09/1999")
    private String birthDate;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "renatin20@hotmail.com")
    private String email;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "larysales01")
    private String password;
}
