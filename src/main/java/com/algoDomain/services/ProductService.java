package com.algoDomain.services;
import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {

    public String saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException;

    public String deleteProduct(Long productId) throws ProductNotFoundException;

    public String updateProduct(long pid, ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException;

    public ProductResponse getProduct(Long pid) throws ProductNotFoundException;

    public List<ProductResponse> getAllProducts();

}
