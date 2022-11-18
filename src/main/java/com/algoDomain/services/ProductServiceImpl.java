package com.algoDomain.services;

import com.algoDomain.dto.ProductRequestDto;
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
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<?> saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findByName(product.getProductName());
        if (optionalProduct.isPresent()) {
            throw new ProductAlreadyPresentException("Product is already present");
        }
        productRepo.save(productMapper.DtotoProd(product));
        return ResponseEntity.ok("Product Added Successfully");
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(productId);
        product.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        productRepo.deleteById(productId);
        return ResponseEntity.ok("Product deleted successfully");

    }

    @Override
    public ResponseEntity<?> updateProduct(long pid, ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        Optional<Product> optionalProduct1 = productRepo.findByName(product.getProductName());
        if (optionalProduct1.isPresent()) {
            throw new ProductAlreadyPresentException("Product with name " + product.getProductName() + " Already exist");
        }
        Product product1 = productMapper.DtotoProd(product);
        product1.setProductId(pid);

        productRepo.save(product1);

        return ResponseEntity.ok("Product updated successfully");

    }

    @Override
    public ResponseEntity<?> getProduct(Long pid) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
//        if (optionalProduct == null) {
//            throw new ProductNotFoundException("Product is not present");
//        }
        ProductResponse productResponse = productMapper.ProdToProdResponse(optionalProduct.get());
        return ResponseEntity.ok(productResponse);

    }



    @Override
    public ResponseEntity<?> getAllProducts() {
        List<ProductResponse> productResponseList =new ArrayList<>();
       productRepo.findAll().forEach(product -> {
           productResponseList.add(productMapper.ProdToProdResponse(product));

       });

        return new ResponseEntity<>(productResponseList, HttpStatus.ACCEPTED);
    }


}
