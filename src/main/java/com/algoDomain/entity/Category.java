package com.algoDomain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cat_id;

    private String cat_name;

    private int discount;
    private int gst;
    private int del_charges;

    public Category() {
    }

    public Category(String cat_name, int discount, int gst, int del_charges) {
        this.cat_name = cat_name;
        this.discount = discount;
        this.gst = gst;
        this.del_charges = del_charges;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getDel_charges() {
        return del_charges;
    }

    public void setDel_charges(int del_charges) {
        this.del_charges = del_charges;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cat_id=" + cat_id +
                ", cat_name='" + cat_name + '\'' +
                ", discount=" + discount +
                ", gst=" + gst +
                ", del_charges=" + del_charges +
                '}';
    }
    //    @OneToMany(cascade= CascadeType.REFRESH, fetch=FetchType.EAGER)
//    private List<Product> productList;

}
