package com.algoDomain.mappers;

import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.entity.Category;
import com.algoDomain.entity.Product;
import com.algoDomain.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {


    @Autowired
    private CategoryRepo categoryRepo;

    public Product DtotoProd(ProductRequestDto productRequestDto){
        Product product =new Product();
        product.setName(productRequestDto.getProductName());
        product.setProductType(productRequestDto.getProductType());
        product.setBasePrice(productRequestDto.getBasePrice());
        Category category = categoryRepo.findByCat_Name(productRequestDto.getCatName()).get();
        product.setCat(category);
        return product;

    }









}
