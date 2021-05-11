package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }
    @GetMapping("/{productId}/")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "name", "description", 1.0);
    }
    @DeleteMapping("/{productId}/")
    public void deleteProduct(@PathVariable Long productId) {

    }
    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "name", "description", 1.0);
    }
    @PostMapping
    public void createProduct(@PathVariable ProductDto productDto) {
    }
}