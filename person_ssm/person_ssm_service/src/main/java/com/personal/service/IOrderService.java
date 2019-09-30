package com.personal.service;

import com.personal.domain.Order;

import java.util.List;

public interface IOrderService {

    /**
     *分页查询订单信息
     */
    List<Order> findAll(int page,int size) throws Exception;

    Order findById(String orderId) throws Exception;
}
