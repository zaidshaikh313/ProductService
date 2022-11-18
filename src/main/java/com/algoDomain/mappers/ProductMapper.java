package com.algoDomain.mappers;

import com.algoDomain.dto.Charges;
import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.dto.ServerResponse;
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

    public Product DtotoProd(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getProductName());
        product.setProductType(productRequestDto.getProductType());
        product.setBasePrice(productRequestDto.getBasePrice());
        product.setInCart(false);
        Category category = categoryRepo.findByCat_Name(productRequestDto.getCatName()).get();
        product.setCat(category);
        return product;

    }

    public ProductResponse ProdToProdResponse(Product product) {
        Category category = product.getCat();
        float discount = product.getBasePrice() * category.getDiscount() / 100;
        float gst = product.getBasePrice() * category.getGst() / 100;

        float finalPrice = product.getBasePrice() + gst + category.getDel_charges() - discount;
        return new ProductResponse(product.getProductId(),
                product.getName(),
                product.getProductType(),
                category.getCat_name(),
                product.getBasePrice(),
                discount,
                new Charges(gst, category.getDel_charges()),
                finalPrice
        );
    }


}
