package com.zip.Product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Setter
@Getter
public class ProductDto {

    private Integer id;
    @NotBlank
    private String name;
    private String description;
    @Pattern(regexp = "food|sports|household|music|electronic|appliance", message = "Type must be one of the following: food, sports, household, music, electronic, appliance")
    private String type;
    private Integer quantity;
    private Integer price;
    private String requirements;
}
