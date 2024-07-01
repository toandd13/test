package com.example.test.controller;

import com.example.test.entities.Product;
import com.example.test.repository.ProductRepository;
import com.example.test.request.ProductRequest;
import com.example.test.response.ProductResponse;
import com.example.test.response.ResponsePage;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponsePage<Product, ProductResponse> getPhanTrang(Pageable pageable) {
        return productService.getAllProduct(pageable);
    }


    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }


    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Optional<Product> productDate = productRepository.findById(product.getId());

        if (productDate.isPresent()) {
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
