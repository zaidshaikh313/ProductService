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

    @PutMapping("/add/{pid}")
    public ResponseEntity<?> addToCart(@PathVariable("pid") long pid){
        try{
           return cartService.addToCart(pid);
        } catch (ProductAlreadyPresentException e)  {
            return new ResponseEntity<ServerResponse>(new ServerResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }
    @PutMapping("/remove/{pid}")
    public ResponseEntity<?> removeFromCart(@PathVariable("pid") long pid){
        try{
            return cartService.removeFromCart(pid);
        } catch (ProductNotFoundException e)  {
            return new ResponseEntity<ServerResponse>(new ServerResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllInCart(){
        return cartService.getAllInCart();
    }
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){

        return new ResponseEntity<>( productService.getAllProducts(),HttpStatus.ACCEPTED);
    }


}
