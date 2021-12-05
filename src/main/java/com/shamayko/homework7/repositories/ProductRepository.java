package com.shamayko.homework7.repositories;

import com.shamayko.homework7.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
    List<Product> findAllByCostBetween(Integer min, Integer max);

}
