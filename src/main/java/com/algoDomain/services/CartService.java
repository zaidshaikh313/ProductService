package com.algoDomain.services;


import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    public ResponseEntity<?> addToCart(Long pid) throws ProductAlreadyPresentException;
    public ResponseEntity<?> removeFromCart(Long pid) throws ProductNotFoundException;

    public ResponseEntity<?> getAllInCart();
}
