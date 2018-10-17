package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name = "brand_cd")
    private String brandCode;

    @Column(name = "product_id")
    private String productCode;

    public Product() {
    }

    public Product(String brandCode, String productCode) {
        this.brandCode = brandCode;
        this.productCode = productCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"brandCode\":\"" + brandCode + "\""
                + ", \"productCode\":\"" + productCode + "\""
                + "}";
    }
}
