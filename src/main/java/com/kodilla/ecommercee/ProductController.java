package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        return products;
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) {
        return new ProductDto();
    }

   @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
    }

    @PutMapping(value = "updateProduct")
    public void updateProduct(@RequestBody ProductDto productDto) {
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
    }
}