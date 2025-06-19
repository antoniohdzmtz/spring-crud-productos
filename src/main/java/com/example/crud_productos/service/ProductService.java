package com.example.crud_productos.service;

import com.example.crud_productos.entity.Product;
import com.example.crud_productos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
