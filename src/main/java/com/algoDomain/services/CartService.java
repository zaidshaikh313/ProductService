package com.algoDomain.services;


import com.algoDomain.dto.ProductResponse;
import com.algoDomain.dto.ServerResponse;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    public ServerResponse addToCart(Long pid) throws ProductAlreadyPresentException;
    public ServerResponse removeFromCart(Long pid) throws ProductNotFoundException;

    public List<ProductResponse> getAllInCart();
}
