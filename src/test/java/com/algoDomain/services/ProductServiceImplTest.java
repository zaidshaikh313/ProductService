package com.algoDomain.services;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.entity.Product;
import com.algoDomain.exceptions.ProductAlreadyPresentException;
import com.algoDomain.exceptions.ProductNotFoundException;
import com.algoDomain.mappers.ProductMapper;
import com.algoDomain.repositories.ProductRepo;
import com.algoDomain.util.ProductBuilder;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepo productRepo;
    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testSaveProduct() throws ProductAlreadyPresentException {
        when(productMapper.DtotoProd(ArgumentMatchers.any())).thenReturn(ProductBuilder.getProduct());
        when(productRepo.findByName(any())).
                thenReturn(Optional.empty());
        assertEquals("Product Added Successfully", productService.saveProduct(ProductBuilder.getProductRequestDto()));
    }

    @Test
    void testDeleteProduct() throws ProductNotFoundException {
        when(productRepo.findById(any())).thenReturn(Optional.of(ProductBuilder.getProduct()));
        assertEquals("Product deleted successfully",productService.deleteProduct(50L));
    }

    @Test
    void updateProduct() throws ProductAlreadyPresentException, ProductNotFoundException {
        when(productRepo.findById(any())).thenReturn(Optional.of(ProductBuilder.getProduct()));
        when(productRepo.findByName(any())).thenReturn(Optional.empty());
        when(productMapper.DtotoProd(any())).thenReturn(ProductBuilder.getProduct());
        assertEquals("Product updated successfully",productService.updateProduct(50L,ProductBuilder.getProductRequestDto()));
    }

    @Test
    void getProduct() throws ProductNotFoundException {
        when(productRepo.findById(any())).thenReturn(Optional.of(ProductBuilder.getProduct()));
        when(productMapper.ProdToProdResponse(any())).thenReturn(ProductBuilder.getProductDto());
        assertEquals(50L,  productService.getProduct(50L).getId());

    }

    @Test
    void getAllProducts() {
        when(productRepo.findAll()).thenReturn(ProductBuilder.getListProducts());
        when(productMapper.ProdToProdResponse(any())).thenReturn(ProductBuilder.getProductDto());
        assertEquals(2, productService.getAllProducts().size());
    }
}