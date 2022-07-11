package com.toy.week04.controller;

import com.toy.week04.models.Product;
import com.toy.week04.models.ProductMypriceRequestDto;
import com.toy.week04.models.ProductRepository;
import com.toy.week04.models.ProductRequestDto;
import com.toy.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> readProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProducts(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long udateProducts(@PathVariable Long id, @RequestBody ProductMypriceRequestDto mypriceRequestDto){
        productService.update(id, mypriceRequestDto);
        return id;
    }

    @DeleteMapping("/api/products/{id}")
    public Long deleteProducts(@PathVariable Long id){
        productRepository.deleteById(id);
        return id;
    }

}
