package com.algoDomain.util;

import com.algoDomain.dto.Charges;
import com.algoDomain.dto.ProductRequestDto;
import com.algoDomain.dto.ProductResponse;
import com.algoDomain.entity.Category;
import com.algoDomain.entity.Product;

import java.util.Arrays;
import java.util.List;

public class ProductBuilder {

    public static Category category = new Category(50L,"Electronics",19f,18f,300f);

    public static List<ProductResponse> getListProductDto(){
        return Arrays.asList(new ProductResponse(1L,"Lenevo","Laptop","Electronics",2000f,19f,new Charges(18f,300f),3010f,false),
        new ProductResponse(2L,"Dell","Laptop","Electronics",20000f,19f,new Charges(18f,300f),30100f,false));

    }

    public static List<Product> getListProducts(){
        return Arrays.asList(new Product("Lenevo","Laptop",2000f,false,category),
                new Product("Dell","Laptop",20000f,false,category)
                );
    }
    public static Product getProduct(){

        return new Product(50L,"HP","Laptop",20000f,false,category);

    }
    public static ProductResponse getProductDto(){
        return  new ProductResponse(50L,"HP","Laptop","Electronics",20000f,19f,new Charges(18f,300f),30100f,false);
    }
    public  static ProductRequestDto getProductRequestDto(){
        return new ProductRequestDto(50L,"HP","Laptop","Electronics",20000f);
    }
}
