package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }
    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(Long productId) {
        return new ProductDto(1L, "name", "description", 1);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(ProductDto productDto) {
        return new ProductDto(1L, "name", "description", 1);
    }
    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(ProductDto productDto) {

    }
}

