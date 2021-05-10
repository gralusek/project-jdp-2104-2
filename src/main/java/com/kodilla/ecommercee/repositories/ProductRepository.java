package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
