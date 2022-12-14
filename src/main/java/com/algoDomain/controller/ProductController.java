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
@CrossOrigin("http://localhost:4200")
public class ProductController {


    @Autowired
    private ProductService productService;

    //Exposing EndPoint to get product based on ProductId
    @GetMapping("/{pid}")
    public ResponseEntity<?> getProduct(@PathVariable("pid") long pid) {
        try {
            return new ResponseEntity<>(productService.getProduct(pid), HttpStatus.ACCEPTED);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }


    //Exposing EndPoint for adding product  in DB
    @PostMapping()
    public ResponseEntity<?> addProd(@RequestBody ProductRequestDto product) {
        try {
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.ACCEPTED);
        } catch (ProductAlreadyPresentException exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    //Exposing EndPoint for Deleting product  in DB
    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deleteProd(@PathVariable("pid") long pid) {
        try {
            return new ResponseEntity<>(productService.deleteProduct(pid), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }


    //Exposing EndPoint for updating product  in DB
    @PutMapping("/{pid}")
    public ResponseEntity<?> updateProd(@PathVariable("pid") long pid, @RequestBody ProductRequestDto productRequestDto) {
        try {
            return new ResponseEntity<>(productService.updateProduct(pid, productRequestDto), HttpStatus.ACCEPTED);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (ProductAlreadyPresentException exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            return new ResponseEntity<ServerResponse>(new ServerResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

        }

    }
}
