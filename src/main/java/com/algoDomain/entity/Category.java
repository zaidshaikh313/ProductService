package com.algoDomain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cat_id;

    private String cat_name;

    private float discount;
    private float gst;
    private float del_charges;

    public Category() {
    }

    public Category(String cat_name, float discount, float gst, float del_charges) {
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getGst() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public float getDel_charges() {
        return del_charges;
    }

    public void setDel_charges(float del_charges) {
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
