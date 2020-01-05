package com.joey.dao;

import com.joey.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 校验用户登录
     * @param uname
     * @param pwd
     * @return
     */
    User checkUserLoginDao(String uname, String pwd);

    /**
     * 修改用户密码
     * @param newPwd
     * @param uid
     * @return
     */
    int changeUserPwdDao(String newPwd, int uid);

    /**
     * 显示全部用户信息
     * @return
     */
    List<User> showUserInfoDao();

    /**
     * 注册新用户
     * @param u
     * @return
     */
    int registerNewUser(User u);
}
