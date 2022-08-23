package com.ineffable.shopfast1_5.Model;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long productid;
    private String categorySlug;
    private String description;
    private String image01;
    private String image02;
    private Double price;
    private String slug;
    private String title;

    @OneToMany(targetEntity = Variant.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_fk", referencedColumnName = "productid")
    private List<Variant> variantList;

    @OneToMany(targetEntity = SubOrder.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_fk", referencedColumnName = "productid")
    private List<SubOrder> subOrderList;

    public Product() {
        variantList = new ArrayList<>();
    }

    public Product(Long productid, String categorySlug, String description, String image01, String image02, Double price, String slug, String title, List<Variant> variantList) {
        this.productid = productid;
        this.categorySlug = categorySlug;
        this.description = description;
        this.image01 = image01;
        this.image02 = image02;
        this.price = price;
        this.slug = slug;
        this.title = title;
        this.variantList = variantList;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage01() {
        return image01;
    }

    public void setImage01(String image01) {
        this.image01 = image01;
    }

    public String getImage02() {
        return image02;
    }

    public void setImage02(String image02) {
        this.image02 = image02;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }
}

/*
productid bigint not null,
category_slug varchar(255),
description varchar(255),
image01 varchar(255),
image02 varchar(255),
price double precision,
slug varchar(255),
title varchar(255),
primary key (productid)
* */