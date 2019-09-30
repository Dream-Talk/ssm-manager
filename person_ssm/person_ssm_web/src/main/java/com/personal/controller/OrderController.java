package com.personal.controller;

import com.github.pagehelper.PageInfo;
import com.personal.domain.Order;
import com.personal.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(
    @RequestParam(name = "page", required = true, defaultValue = "1") int page,
    @RequestParam(name = "size", required = true, defaultValue = "10") int size) throws Exception {
        List<Order> ordersList = orderService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
        Order order = orderService.findById(orderId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}
