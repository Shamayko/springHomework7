package com.shamayko.homework7.repositories.specs;

import com.shamayko.homework7.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> costGreaterOrEqualsThen(Integer cost) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost));
    }

    public static Specification<Product> costLessOrEqualsThen(Integer cost) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost));
    }

    public static Specification<Product> titleLike(String titlePart) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart)));
    }
}
