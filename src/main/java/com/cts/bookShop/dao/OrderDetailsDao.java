package com.cts.bookShop.dao;

import com.cts.bookShop.entity.OrderDetails;
import com.cts.bookShop.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsDao extends CrudRepository<OrderDetails, Integer> {

    List<OrderDetails> findByUser(User user);
}
