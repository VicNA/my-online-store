package ru.geekbrains.myonlinestore.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.myonlinestore.entites.Product;
import ru.geekbrains.myonlinestore.repositories.ProductRepository;
import ru.geekbrains.myonlinestore.repositories.specifications.ProductSpecifications;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> fingAll(int page, int pageSize, String word, Double min, Double max) {
        Specification<Product> spec = Specification.where(null);
        if (word != null) {
            spec = spec.and(ProductSpecifications.titleLike(word));
        }
        if (min != null) {
            spec = spec.and(ProductSpecifications.priceGreaterThanOrEq(min));
        }
        if (max != null) {
            spec = spec.and(ProductSpecifications.priceLesserThanOrEq(max));
        }

        return productRepository.findAll(spec, PageRequest.of(page, pageSize));
    }
}
