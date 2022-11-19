package com.algoDomain.services;
import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.dto.ServerResponse;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {

    public ServerResponse saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException;

    public ServerResponse deleteProduct(Long productId) throws ProductNotFoundException;

    public ServerResponse updateProduct(long pid, ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException;

    public ProductResponse getProduct(Long pid) throws ProductNotFoundException;

    public List<ProductResponse> getAllProducts();

}
