package com.joey.service;

import com.joey.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 校验用户登录信息
     * @param uname
     * @param pwd
     * @return
     */
    User checkUserLoginService(String uname, String pwd);

    /**
     * 修改用户密码
     * @param newPwd
     * @param Uid
     * @return
     */
    int changeUserPwdService(String newPwd, int Uid);

    /**
     * 显示用户信息
     * @return
     */
    List<User> showUserInfoService();

    /**
     * 注册新用户
     * @param u
     * @return
     */
    int registerNewUser(User u);

}
