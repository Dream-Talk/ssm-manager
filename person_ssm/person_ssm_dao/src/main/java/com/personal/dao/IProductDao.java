package com.personal.dao;

import java.util.List;
import com.personal.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface IProductDao {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 插入一个产品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     *根据id查询产品
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
