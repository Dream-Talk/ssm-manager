package com.personal.controller;


import com.personal.domain.Product;
import com.personal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        List<Product> products = productService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
    return mv;
    }
    /**
     * 添加产品接口
     */
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll";
    }


}
