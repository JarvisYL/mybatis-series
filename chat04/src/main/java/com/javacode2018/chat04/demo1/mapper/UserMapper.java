package com.javacode2018.chat04.demo1.mapper;

import com.javacode2018.chat04.demo1.model.UserModel;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public interface UserMapper {

    /**
     * 插入用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    int insertUser(UserModel model);

    int insertUser1(UserModel userModel);
    /**
     * 更新用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    long updateUser(UserModel model);

    /**
     * 根据用户id删除用户信息，返回删除是否成功
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);

}