package com.example.test.service.impl;

import com.example.test.entities.Product;
import com.example.test.repository.ProductRepository;
import com.example.test.request.ProductRequest;
import com.example.test.response.ProductResponse;
import com.example.test.response.ResponsePage;
import com.example.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setColor(productRequest.getColor());
        product.setDescription(productRequest.getDescription());
        product.setOrigin_price(productRequest.getOrigin_price());
        product.setQuantity(productRequest.getQuantity());
        product.setName(productRequest.getName());
        product.setSell_price(productRequest.getSell_price());
        return mapProductResponse(productRepository.save(product));
    }

    @Override
    public ResponsePage<Product , ProductResponse> getAllProduct(Pageable pageable) {
         Page<Product> productPage = productRepository.findAll(pageable);
         return new ResponsePage<>(productPage , ProductResponse.class);
    }

    private ProductResponse mapProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .color(product.getColor())
                .name(product.getName())
                .origin_price(product.getOrigin_price())
                .sell_price(product.getSell_price())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .build();
    }
}
