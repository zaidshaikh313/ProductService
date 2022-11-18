package com.algoDomain.services;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.entity.Product;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.mappers.ProductMapper;
import com.algoDomain.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findByName(product.getProductName());
        if (optionalProduct.isPresent()) {
            throw new ProductAlreadyPresentException("Product is already present");
        }
        Product product1 = productMapper.DtotoProd(product);
        productRepo.save(product1);
        return "Product Added Successfully";
    }

    @Override
    public String deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(productId);
        product.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        productRepo.deleteById(productId);
        return "Product deleted successfully";

    }

    @Override
    public String updateProduct(long pid, ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        Optional<Product> optionalProduct1 = productRepo.findByName(product.getProductName());
        if (optionalProduct1.isPresent()) {
            throw new ProductAlreadyPresentException("Product with name " + product.getProductName() + " Already exist");
        }
        Product product1 = productMapper.DtotoProd(product);
        product1.setProductId(pid);

        productRepo.save(product1);

       return  "Product updated successfully";

    }

    @Override
    public ProductResponse getProduct(Long pid) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
//        if (optionalProduct == null) {
//            throw new ProductNotFoundException("Product is not present");
//        }
        ProductResponse productResponse = productMapper.ProdToProdResponse(optionalProduct.get());
        return (productResponse);

    }



    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponseList =new ArrayList<>();
       productRepo.findAll().forEach(product -> {
           productResponseList.add(productMapper.ProdToProdResponse(product));

       });

        return productResponseList;
    }


}
