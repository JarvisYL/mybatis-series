package com.javacode2018.chat05.demo2;

import com.javacode2018.chat05.demo2.mapper.OrderMapper;
import com.javacode2018.chat05.demo2.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Demo1Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "demo2/mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Test
    public void getById1() {
        OrderModel orderModel = null;
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            orderModel = mapper.getById1(1);
        }
        log.info("-------分割线--------");
        log.info("{}", orderModel.getOrderDetailModelList());
    }

    @Test
    public void getById2() throws IOException {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            //查询订单为1的
            OrderModel orderModel = mapper.getById2(1);
            log.info("{}", orderModel);
            log.info("------------------------------------------------------------");
            //查询订单为2的
            orderModel = mapper.getById2(2);
            log.info("{}", orderModel);
            log.info("------------------------------------------------------------");
            //查询订单为3的
            orderModel = mapper.getById2(3);
            log.info("{}", orderModel);
        }
    }
    @Test
    public void getById3() throws IOException {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            //查询订单为1的
            OrderModel orderModel = mapper.getById3(1);
            log.info("{}", orderModel);
            log.info("------------------------------------------------------------");
            //查询订单为2的
            orderModel = mapper.getById3(2);
            log.info("{}", orderModel);
            log.info("------------------------------------------------------------");
            //查询订单为3的
            orderModel = mapper.getById3(3);
            log.info("{}", orderModel);
        }
    }

}
