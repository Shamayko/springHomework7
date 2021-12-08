package com.shamayko.homework7.controllers;

import com.shamayko.homework7.entites.Product;
import com.shamayko.homework7.exceptions.ResourceNotFoundException;
import com.shamayko.homework7.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/cost_between")
    public List<Product> findByCostBetween(@RequestParam(required = false, defaultValue = "0") Integer min, @RequestParam(required = false, defaultValue = "1000000") Integer max) {
        return productService.findByCostBetween(min, max);
    }

    @GetMapping("/products/change_cost")
    public void changeCost (@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }


}
