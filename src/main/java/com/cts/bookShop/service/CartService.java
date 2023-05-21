package com.cts.bookShop.service;

import com.cts.bookShop.controller.UserController;
import com.cts.bookShop.dao.CartDao;
import com.cts.bookShop.dao.ProductDao;
import com.cts.bookShop.dao.UserDao;
import com.cts.bookShop.entity.Cart;
import com.cts.bookShop.entity.Product;
import com.cts.bookShop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;
    public Cart addToCart(Integer productId){
        Product product= productDao.findById(productId).get();
        String currentUser= UserController.CURRENT_USER;
        User user=null;

        if(currentUser!= null){
            user = userDao.findByUserName(currentUser);

        }
        if(product!= null && user!= null){
            Cart cart = new Cart(product, user);
            return cartDao.save(cart);
        }
        return null;
    }

}
