package com.algoDomain.services;

import com.algoDomain.dto.ProductResponse;
import com.algoDomain.entity.Product;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.mappers.ProductMapper;
import com.algoDomain.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<?> addToCart(Long pid) throws ProductAlreadyPresentException {
        Product optionalProduct = productRepo.findById(pid).get();
        if (optionalProduct.isInCart())
            throw new ProductAlreadyPresentException("Product is already added");

        optionalProduct.setInCart(true);
        productRepo.save(optionalProduct);

        return ResponseEntity.ok("Product added to cart");
    }

    @Override
    public ResponseEntity<?> removeFromCart(Long pid) throws ProductNotFoundException {
        Product product = productRepo.findById(pid).get();
        if (!product.isInCart())
            throw new ProductNotFoundException("Product not present in cart");

        product.setInCart(false);
        productRepo.save(product);
        return ResponseEntity.ok("Product removed from cart");
    }

    @Override
    public ResponseEntity<?> getAllInCart() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        productRepo.findAllByInCart(true).forEach(product -> {
            productResponseList.add(productMapper.ProdToProdResponse(product));
        });
        return new ResponseEntity<>(productResponseList, HttpStatus.ACCEPTED);
    }
}
