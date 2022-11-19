package com.algoDomain.services;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.dto.ServerResponse;
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


//Performing Product DAO Here
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;


    //Saving the product in DB
    @Override
    public ServerResponse saveProduct(ProductRequestDto product) throws ProductAlreadyPresentException {
        // IfProduct is already present throw Exception
        Optional<Product> optionalProduct = productRepo.findByName(product.getProductName());
        if (optionalProduct.isPresent()) {
            throw new ProductAlreadyPresentException("Product is already present");
        }
        //Converting Request Object to Actual Product Object and saving in DB
        Product product1 = productMapper.DtotoProd(product);
        productRepo.save(product1);
        return new ServerResponse("Product Added Successfully");
    }

    //Deleting product from DB if present
    @Override
    public ServerResponse deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(productId);
        product.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        productRepo.deleteById(productId);
        return new ServerResponse("Product deleted successfully");

    }

    //Updating product Entity if present in DB
    @Override
    public ServerResponse updateProduct(long pid, ProductRequestDto product) throws ProductNotFoundException, ProductAlreadyPresentException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));
        //Checking if product with same name already exist
        Optional<Product> optionalProduct1 = productRepo.findByName(product.getProductName());
        if (optionalProduct1.isPresent()) {
            throw new ProductAlreadyPresentException("Product with name " + product.getProductName() + " Already exist");
        }
        //Converting to Product Object and saving in DB
        Product product1 = productMapper.DtotoProd(product);
        product1.setProductId(pid);

        productRepo.save(product1);

        return new ServerResponse("Product updated successfully");

    }

    //Get Product details by given product ID
    @Override
    public ProductResponse getProduct(Long pid) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(pid);
        optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product is not present"));

        ProductResponse productResponse = productMapper.ProdToProdResponse(optionalProduct.get());
        return (productResponse);

    }


    //Getting all products in DB
    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        productRepo.findAll().forEach(product -> {
            productResponseList.add(productMapper.ProdToProdResponse(product));

        });

        return productResponseList;
    }


}
