package com.zip.Product.mapper;

import com.zip.Product.dto.ProductDto;
import com.zip.Product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setType(productDto.getType());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setRequirements(productDto.getRequirements());
        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setType(product.getType());
        productDto.setQuantity(product.getQuantity());
        productDto.setPrice(product.getPrice());
        productDto.setRequirements(product.getRequirements());
        return productDto;
    }
}
