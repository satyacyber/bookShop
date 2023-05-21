package com.cts.bookShop.controller;

import com.cts.bookShop.entity.OrderDetails;
import com.cts.bookShop.entity.OrderInput;
import com.cts.bookShop.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;
    @PostMapping("/placeOrder/{directBuy}")
    public void placeOrder(@PathVariable boolean directBuy, @RequestBody OrderInput orderInput) {
        orderDetailsService.placeOrder(directBuy, orderInput);
    }

    @GetMapping("/getOrderDetails")
    public List<OrderDetails> getOrderDetails(){
        return orderDetailsService.getOrderDetails();
    }
}
