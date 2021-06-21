package com.javacode2018.chat05.demo1.mapper;

import com.javacode2018.chat05.demo1.model.OrderModel;

public interface OrderMapper {
    OrderModel getById(Integer id);
    OrderModel getById1(int id);
}
