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
public class BuyerDTO implements Serializable {

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "Vinicius Jardim")
    private String name;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "123987456")
    private Long cpf;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "01/01/1990")
    private String birthDate;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "vinizao@hotmail.com")
    private String email;

    @NotBlank
    @NotNull
    @ApiModelProperty(example = "helo1234")
    private String password;
}
