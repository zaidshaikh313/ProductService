package com.algoDomain.controller;

import com.algoDomain.dto.ServerResponse;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.services.CartService;
import com.algoDomain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200")
public class CartContoller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;


    //Exposing EndPoint for adding product  in Cart
    @PutMapping("/add/{pid}")
    public ResponseEntity<?> addToCart(@PathVariable("pid") long pid) {
        try {
            return new ResponseEntity<>(cartService.addToCart(pid), HttpStatus.OK);
        } catch (ProductAlreadyPresentException e) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    //Exposing EndPoint for Removing product From Cart
    @PutMapping("/remove/{pid}")
    public ResponseEntity<?> removeFromCart(@PathVariable("pid") long pid) {
        try {
            return new ResponseEntity<>(cartService.removeFromCart(pid), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    //Exposing EndPoint for getting all Products present in Cart
    @GetMapping()
    public ResponseEntity<?> getAllInCart() {

        return new ResponseEntity<>(cartService.getAllInCart(), HttpStatus.OK);
    }


    //Exposing EndPoint for getting all Products present in DB
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }


}
