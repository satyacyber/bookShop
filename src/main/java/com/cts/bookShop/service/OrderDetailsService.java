package com.cts.bookShop.service;

import com.cts.bookShop.controller.UserController;
import com.cts.bookShop.dao.CartDao;
import com.cts.bookShop.dao.OrderDetailsDao;
import com.cts.bookShop.dao.ProductDao;
import com.cts.bookShop.dao.UserDao;
import com.cts.bookShop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    public static  final String ORDER_STATUS = "Placed";

    public List<OrderDetails> getOrderDetails(){
        String currentUser = UserController.CURRENT_USER;
        User user = userDao.findByUserName(currentUser);
        return orderDetailsDao.findByUser(user);
    }
    public void placeOrder(boolean directBuy, OrderInput orderInput){

        List<ProductDetails> productDetailsList = orderInput.getProductDetails();

        for(ProductDetails o: productDetailsList){
            Product product = productDao.findById(o.getProductId()).get();

            String currentUser = UserController.CURRENT_USER;

            User user = userDao.findByUserName(currentUser);

            OrderDetails orderDetails = new OrderDetails(orderInput.getFullName(),
                    orderInput.getAddress(),
                    orderInput.getContactNumber(),
                    ORDER_STATUS,
                    product.getPrice()* o.getQuantity(),
                    product,
                    user);

            if(!directBuy){
                List<Cart> carts = cartDao.findByUser(user);
                carts.stream().forEach(x-> cartDao.deleteById(x.getCartId()));
            }
            orderDetailsDao.save(orderDetails);
        }
    }
}
