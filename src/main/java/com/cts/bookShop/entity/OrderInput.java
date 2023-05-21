package com.cts.bookShop.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderInput {

    private String fullName;
    private String address;
    private String contactNumber;
    private List<ProductDetails> productDetails;

    public OrderInput(){

    }
    public OrderInput(String fullName, String address, String contactNumber, List<ProductDetails> productDetails) {
        this.fullName = fullName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.productDetails = productDetails;
    }
}
