package com.zip.Product.service;

import com.zip.Product.dto.ProductDto;
import com.zip.Product.entity.Product;
import com.zip.Product.mapper.ProductMapper;
import com.zip.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService{

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    public Optional<ProductDto> getById(Integer id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductDto updateProduct(Integer id, ProductDto  productDto) {
        if (productRepository.existsById(id)) {
            Product product = productMapper.toEntity(productDto);
            product.setId(id);
            return productMapper.toDto(productRepository.save(product));
        }else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    public void deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }
}
