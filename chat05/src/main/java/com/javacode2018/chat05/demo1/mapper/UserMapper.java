package com.javacode2018.chat05.demo1.mapper;


import com.javacode2018.chat05.demo1.model.UserModel;

public interface UserMapper {
    UserModel getById1(Integer id);
    /*仅演示子查询传多个值，并不会真的查出数据，user表中都没有createTime字段*/
    UserModel getById2(Integer id,Long createTime);
}
