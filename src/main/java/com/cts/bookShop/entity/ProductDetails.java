package com.cts.bookShop.entity;

import lombok.Data;

@Data
public class ProductDetails {

    private Integer productId;
    private Integer quantity;

    public ProductDetails(){

    }
    public ProductDetails(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
