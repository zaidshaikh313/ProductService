package com.algoDomain.dto;

public class ProductRequestDto {


    private String productName;

    private String productType;

    private String catName;

    private float basePrice;

    public ProductRequestDto(long productId, String productName, String productType, String catName, float basePrice) {
        this.productName = productName;
        this.productType = productType;
        this.catName = catName;
        this.basePrice = basePrice;
    }

    public ProductRequestDto() {
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
}
