package com.cts.bookShop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Cart {

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Cart() {
    }
    //comment


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @OneToOne
    private Product product;

    @OneToOne
    private  User user;







}
