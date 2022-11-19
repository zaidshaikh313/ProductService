package com.algoDomain.entity;

import javax.persistence.*;


//Creating Product Table
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String productType;
    private float basePrice;

    private boolean inCart;

    //Mapping with category to store category id in product table
    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="pr_cat_id")
    private Category cat;


 //Constructor for creating product entity
    public Product(String name, String productType, float basePrice, boolean inCart, Category cat) {
        this.name = name;
        this.productType = productType;
        this.basePrice = basePrice;
        this.inCart = inCart;
        this.cat = cat;
    }
    public Product(Long pid,String name, String productType, float basePrice, boolean inCart, Category cat) {
        this.name = name;
        this.productType = productType;
        this.basePrice = basePrice;
        this.inCart = inCart;
        this.cat = cat;
        this.productId=pid;
    }



    public Product() {
    }

    //Getters And Setters to get and set all attributes
    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                ", basePrice=" + basePrice +
                ", cat=" + cat +
                '}';
    }
}
