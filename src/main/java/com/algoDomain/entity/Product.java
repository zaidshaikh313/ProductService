package com.algoDomain.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String productType;
    private Long basePrice;

    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="pr_cat_id")
    private Category cat;

    public Product(String name, String productType, Long basePrice, Category cat) {
        this.name = name;
        this.productType = productType;
        this.basePrice = basePrice;
        this.cat = cat;
    }

    public Product() {
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

    public Long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Long basePrice) {
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
