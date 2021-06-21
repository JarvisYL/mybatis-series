package com.javacode2018.chat03.demo3;

import com.javacode2018.chat03.demo3.mapper.OrderMapper;
import com.javacode2018.chat03.demo3.mapper.UserMapper;
import com.javacode2018.chat03.demo3.model.OrderModel;
import com.javacode2018.chat03.demo3.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
@Slf4j
public class Demo3Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "demo3/mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Test
    public void test() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //执行查询操作
            List<UserModel> userModelList = userMapper.getList();
            userModelList.forEach(item -> {
                log.info("{}", item);
            });

            log.info("----------------------------------");
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            //执行查询操作
            List<OrderModel> orderModelList = orderMapper.getList();
            orderModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

}