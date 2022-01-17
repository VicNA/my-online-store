package ru.geekbrains.myonlinestore.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.myonlinestore.entites.Product;

public class ProductSpecifications {

    public static Specification<Product> titleLike(String word) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + word + "%"));
    }

    public static Specification<Product> priceGreaterThanOrEq(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLesserThanOrEq(double price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }
}
