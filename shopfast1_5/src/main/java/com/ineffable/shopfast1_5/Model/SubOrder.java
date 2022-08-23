package com.ineffable.shopfast1_5.Model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

@Entity
public class SubOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long sid;
    private Long quantity;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_fk", referencedColumnName = "productid")
    private Product product;

    public SubOrder(Long sid, Long quantity, Product product) {
        this.sid = sid;
        this.quantity = quantity;
        this.product = product;
    }

    public SubOrder() {
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
