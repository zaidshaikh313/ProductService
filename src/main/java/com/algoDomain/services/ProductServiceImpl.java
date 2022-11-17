package com.algoDomain.services;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.entity.Product;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.mappers.ProductMapper;
import com.algoDomain.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;

    public ResponseEntity<?> saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findByName(product.getProductName());
        if (optionalProduct.isPresent()){
            throw new ProductAlreadyPresentException("Product is already present");
        }

        productRepo.save(productMapper.DtotoProd(product));
        return ResponseEntity.ok("Product Added Successfully");
    }

    public ResponseEntity<?> deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent()){
            productRepo.deleteById(productId);
        }
        else{
            throw new ProductNotFoundException("Product is not present");

        }
        return ResponseEntity.ok("Product deleted successfully");

    }
    public ResponseEntity<?> updateProduct(long pid,ProductRequestDto product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        if (optionalProduct.isPresent()){
            Product product1 = productMapper.DtotoProd(product);
            product1.setProductId(pid);
            productRepo.save(product1);
        }
        else{
            throw new ProductNotFoundException("Product is not present");

        }
        return ResponseEntity.ok("Product updated successfully");

    }

}
