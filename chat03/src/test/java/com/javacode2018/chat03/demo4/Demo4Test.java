package com.javacode2018.chat03.demo4;

import com.javacode2018.chat03.demo4.dto.UserFindDto;
import com.javacode2018.chat03.demo4.mapper.UserMapper;
import com.javacode2018.chat03.demo4.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
@Slf4j
public class Demo4Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "demo4/mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     *传递一个String参数
     */
    @Test
    public void getByName() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByName("路人甲Java");
            log.info("{}", userModel);
        }
    }

    /**
     * 传递一个Map参数
     */
    @Test
    public void getByMap() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", "1L");
            map.put("name", "张学友");
            List<UserModel> userModelList = userMapper.getByMap(map);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    /**
     * 传递一个java对象参数
     */
    @Test
    public void getListByUserFindDto() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserFindDto userFindDto = UserFindDto.builder().userId(1L).userName("张学友").build();
            List<UserModel> userModelList = userMapper.getListByUserFindDto(userFindDto);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    /**
     *传递多参数，且用@param指定参数名称
     */
    @Test
    public void getByIdOrName() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByIdOrName(1L, "路人甲Java");
            log.info("{}", userModel);
        }
    }

    /**
     * 传递一个Collection参数
     */
    @Test
    public void getListByIdCollection() {
        log.info("----------");
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> userIdList = Arrays.asList(1L, 3L);
            List<UserModel> userModelList = userMapper.getListByIdCollection(userIdList);
            userModelList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    /**
     * ResultHandler作为参数
     */
    @Test
    public void getList() {
        log.info("----------");
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.getList(context -> {
                //将context参数转换为DefaultResultContext对象
                DefaultResultContext<UserModel> defaultResultContext = (DefaultResultContext<UserModel>) context;
                log.info("{}", defaultResultContext.getResultObject());
                //遍历到第二条之后停止
                if (defaultResultContext.getResultCount() == 2) {
                    //调用stop方法停止遍历，stop方法会更新内部的一个标志，置为停止遍历
                    defaultResultContext.stop();
                }
            });
        }
    }

}