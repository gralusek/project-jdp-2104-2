package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.dbServices.ProductDbService;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exceptions.ProductNotExist;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductDbService productDbService;

    @Autowired
    public ProductController(ProductMapper productMapper, ProductDbService productDbService) {
        this.productMapper = productMapper;
        this.productDbService = productDbService;
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<Product> products = productDbService.getAllCProducts();
        return productMapper.mapToProductDtoList(products);
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotExist {
        return productMapper.mapToProductDto(
                productDbService.getProduct(productId).orElseThrow(ProductNotExist::new)
        );
    }

   @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productDbService.deleteProduct(productId);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.deleteProduct(product.getId());
        productDbService.saveProduct(product);
        return productMapper.mapToProductDto(product);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
    }
}