package com.algoDomain.dto;

public class ProductRequestDto {


    private String productName;

    private String productType;

    private String catName;

    private Long basePrice;

    public ProductRequestDto(long productId, String productName, String productType, String catName, Long basePrice) {
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

    public Long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Long basePrice) {
        this.basePrice = basePrice;
    }
}
