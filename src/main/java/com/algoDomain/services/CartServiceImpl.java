package com.algoDomain.services;

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

//Performing all the DAO Heree
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

    //Method to add product to Cart
    @Override
    public ServerResponse addToCart(Long pid) throws ProductAlreadyPresentException {
        //Fetching product by productId
        Product optionalProduct = productRepo.findById(pid).get();
        if (optionalProduct.isInCart())
            throw new ProductAlreadyPresentException("Product is already added");

        //Setting inCart toTrue to Add product to cart and updating it in DB
        optionalProduct.setInCart(true);
        productRepo.save(optionalProduct);

        return new ServerResponse("Product added to cart");
    }


    //Method to Remove product from Cart
    @Override
    public ServerResponse removeFromCart(Long pid) throws ProductNotFoundException {
        //Fetching product by productId
        Product product = productRepo.findById(pid).get();
        if (!product.isInCart())
            throw new ProductNotFoundException("Product not present in cart");

        //Setting inCart to False For removing product from cart and updating it in DB
        product.setInCart(false);
        productRepo.save(product);
        return new ServerResponse("Product removed from cart");
    }

    //Getting all the Products in Cart
    @Override
    public List<ProductResponse> getAllInCart() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        //Fetching Products which are in Cart
        productRepo.findAllByInCart(true).forEach(product -> {
            productResponseList.add(productMapper.ProdToProdResponse(product));
        });
        return (productResponseList);
    }
}
