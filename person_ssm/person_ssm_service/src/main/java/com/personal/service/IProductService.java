package com.personal.service;

import java.util.List;
import com.personal.domain.Product;

public interface IProductService {
    /**
     * 查询所有
     */
    List<Product> findAll () throws Exception;
    /**
     * 添加产品
     */
    void save(Product product) throws Exception;
}
