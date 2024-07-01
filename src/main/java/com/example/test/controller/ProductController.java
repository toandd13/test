package com.example.test.controller;

import com.example.test.entities.Product;
import com.example.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")

public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/phan-trang")
    public Page<Product> getPhanTrang(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "ten", defaultValue = "") String name

    ) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByNameContaining(pageable, name);

    }



    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        try {
            return new ResponseEntity<>(this.productRepository.save(product), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Optional<Product> productDate = productRepository.findById(product.getId());

        if (productDate.isPresent()) {
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
