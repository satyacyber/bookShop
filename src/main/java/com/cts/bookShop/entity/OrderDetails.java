package com.cts.bookShop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String userFullName;
    private String orderDeliveryAddress;
    private String orderContactNumber;
    private String orderStatus;
    private Double orderAmount;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public OrderDetails() {

    }

    public OrderDetails(String userFullName, String orderDeliveryAddress, String orderContactNumber,
                        String orderStatus, Double orderAmount, Product product, User user) {
        this.orderId = orderId;
        this.userFullName = userFullName;
        this.orderDeliveryAddress = orderDeliveryAddress;
        this.orderContactNumber = orderContactNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }
}
