package com.example.test.service;

import com.example.test.entities.Product;
import com.example.test.request.ProductRequest;
import com.example.test.response.ProductResponse;
import com.example.test.response.ResponsePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {


    ProductResponse createProduct(ProductRequest productRequest);

    ResponsePage<Product , ProductResponse> getAllProduct(Pageable pageable);

}
