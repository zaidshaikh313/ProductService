package com.algoDomain.dto;

public class ProductResponse {

    private Long id;
    private String name;
    private String productType;
    private String category;
    private float basePrice;
    private float discount;
    private Charges charges;
    private float finalPrice;

    private boolean inCart;

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, String productType, String category, float basePrice, float discount, Charges charges, float finalPrice,boolean inCart) {

        this.id = id;
        this.name = name;
        this.productType = productType;
        this.category = category;
        this.basePrice = basePrice;
        this.discount = discount;
        this.charges = charges;
        this.finalPrice = finalPrice;
        this.inCart=inCart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Charges getCharges() {
        return charges;
    }

    public void setCharges(Charges charges) {
        this.charges = charges;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
}
