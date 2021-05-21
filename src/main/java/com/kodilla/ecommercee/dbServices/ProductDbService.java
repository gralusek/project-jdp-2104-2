package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exceptions.ProductNotExist;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

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

    public ProductDto updateProduct(final Long productId, final ProductDto productDto) throws ProductNotExist {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setName(productDto.getName());
                    productRepository.save(product);
                    return productMapper.mapToProductDto(product);
                })
                .orElseThrow(() -> new ProductNotExist());
    }
}
