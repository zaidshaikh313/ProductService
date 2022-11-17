package com.algoDomain.controller;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ServerResponse;
import com.algoDomain.entity.Product;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prod")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/{pid}")
    public ResponseEntity<?> getProduct(@PathVariable("pid") long pid){
        try{
           return productService.getProduct(pid);
        }
        catch (ProductNotFoundException exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }


    @PostMapping()
    public ResponseEntity<?> addProd(@RequestBody ProductRequestDto product) {
        try {
            return productService.saveProduct(product);
        }
        catch (ProductAlreadyPresentException exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }

    }
    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deleteProd(@PathVariable("pid") long pid) {
        try {
            return productService.deleteProduct(pid);
        }
        catch (ProductNotFoundException exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }

    }
    @PutMapping("/{pid}")
    public ResponseEntity<?> updateProd(@PathVariable("pid") long pid, @RequestBody ProductRequestDto productRequestDto) {
        try {
            return productService.updateProduct(pid,productRequestDto);
        }
        catch (ProductNotFoundException exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
        catch (ProductAlreadyPresentException exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
        catch (Exception exception){
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }

    }
}
