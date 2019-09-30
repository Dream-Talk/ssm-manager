package com.personal.dao;

import com.personal.domain.Member;
import com.personal.domain.Order;
import com.personal.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
    @Result(id=true,column = "id",property = "id"),
    @Result(column = "orderNum",property = "orderNum"),
    @Result(column = "orderTime",property = "orderTime"),
    @Result(column = "orderStatus",property = "orderStatus"),
    @Result(column = "peopleCount",property = "peopleCount"),
    @Result(column = "payType",property = "payType"),
    @Result(column = "orderDesc",property = "orderDesc"),
    @Result(column = "productId",property = "product",javaType = Product.class,
    one = @One(select = "com.personal.dao.IProductDao.findById"))
    })
    List<Order> findAll() throws Exception;

     @Select("select * from orders where id = #{orderId}")
     @Results({
             @Result(id=true,column = "id",property = "id"),
             @Result(column = "orderNum",property = "orderNum"),
             @Result(column = "orderTime",property = "orderTime"),
             @Result(column = "orderStatus",property = "orderStatus"),
             @Result(column = "peopleCount",property = "peopleCount"),
             @Result(column = "payType",property = "payType"),
             @Result(column = "orderDesc",property = "orderDesc"),
             @Result(column = "productId",property = "product",javaType = Product.class,
                     one = @One(select = "com.personal.dao.IProductDao.findById")),
             @Result(property = "member",column = "memberId",javaType = Member.class,
                     one = @One(select = "com.personal.dao.IMemberDao.findById")),
             @Result(property = "travellers",column = "id",javaType =java.util.List.class,
                     many = @Many(select = "com.personal.dao.ITravellerDao.findById"))
     })
    Order findById(String orderId);
}
