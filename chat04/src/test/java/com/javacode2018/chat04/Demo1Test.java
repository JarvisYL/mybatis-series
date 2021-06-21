package com.javacode2018.chat04;

import com.javacode2018.chat04.demo1.mapper.UserMapper;
import com.javacode2018.chat04.demo1.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
@Slf4j
public class Demo1Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "demo1/mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Test
    public void insertUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建UserModel对象
            UserModel userModel = UserModel.builder().id(6L).name("php").age(30).salary(50000D).sex(1).build();
            //执行插入操作
            int insert = mapper.insertUser(userModel);
            log.info("影响行数：{}", insert);
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建UserModel对象
            UserModel userModel = UserModel.builder().id(1L).name("路人甲Java，尼玛").age(18).salary(5000D).sex(0).build();
            //执行更新操作
            long result = mapper.updateUser(userModel);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //定义需要删除的用户id
            Long userId = 1L;
            //执行删除操作
            boolean result = mapper.deleteUser(userId);
            log.info("第1次删除:id={},返回值:{}", userId, result);
            result = mapper.deleteUser(userId);
            log.info("第2次删除:id={},返回值:{}", userId, result);
        }
    }
    @Test
    public void insertUser1() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //创建UserModel对象
            UserModel userModel = UserModel.builder().name("陈宝国").age(30).salary(50000D).sex(1).build();
            //执行插入操作
            int insert = mapper.insertUser1(userModel);
            log.info("影响行数：{}", insert);
            log.info("{}", userModel);
        }
    }
}