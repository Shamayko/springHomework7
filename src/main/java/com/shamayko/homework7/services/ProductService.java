package com.shamayko.homework7.services;

import com.shamayko.homework7.entites.Product;
import com.shamayko.homework7.exceptions.ResourceNotFoundException;
import com.shamayko.homework7.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List <Product> findAll() {
        return productRepository.findAll();
    }

    public Optional <Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById (Long id) {
        productRepository.deleteById(id);
    }


    @Transactional
    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to change product's cost. Product not found, id: " + productId));
        product.setCost(product.getCost() + delta);
    }

    public List<Product> findByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }


}
