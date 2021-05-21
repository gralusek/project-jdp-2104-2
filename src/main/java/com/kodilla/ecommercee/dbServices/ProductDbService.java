package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    private final ProductRepository productRepository;

    public List<Product> getAllCProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(final Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(final Long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(final Long id){
        productRepository.deleteById(id);
    }
}
