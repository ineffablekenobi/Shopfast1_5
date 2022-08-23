package com.ineffable.shopfast1_5.DTO;

import java.util.Map;

public class OrderRequest {
    private String username;
    private Map<Long, Long> subOrders; // productId -> quantity

    public OrderRequest() {
    }

    public OrderRequest(String username, Map<Long, Long> subOrders) {
        this.username = username;
        this.subOrders = subOrders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Long, Long> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(Map<Long, Long> subOrders) {
        this.subOrders = subOrders;
    }
}
