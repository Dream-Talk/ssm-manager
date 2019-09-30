package com.personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.personal.dao.IOrderDao;
import com.personal.domain.Order;
import com.personal.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List<Order> orders = orderDao.findAll();
        return orders;
    }

    @Override
    public Order findById(String orderId) throws Exception {
        return   orderDao.findById(orderId);
    }
}
