package com.algoDomain.services;
import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public ResponseEntity<?> saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException;

    public ResponseEntity<?> deleteProduct(Long productId) throws ProductNotFoundException;

    public ResponseEntity<?> updateProduct(long pid,ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException;

    public ResponseEntity<?> getProduct(Long pid) throws ProductNotFoundException;



    public ResponseEntity<?> getAllProducts();

}
