package com.joey.service.Impl;

import com.joey.dao.Impl.UserDaoImpl;
import com.joey.dao.UserDao;
import com.joey.pojo.User;
import com.joey.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    UserDao ud = new UserDaoImpl();
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        logger.debug(uname + "发起登录请求");
        User u = ud.checkUserLoginDao(uname, pwd);
        if (u != null){
            logger.debug(uname + "登陆成功");
        }else {
            logger.debug(uname + "登陆失败");
        }
        return u;
    }

    @Override
    public int changeUserPwdService(String newPwd, int Uid) {
        logger.debug(Uid + ":发起修改密码请求");
        //返回值flag是update语句影响的条数，若查询新密码与原密码相同，虽然不会操作，但也会返回1
        int flag = ud.changeUserPwdDao(newPwd, Uid);
        if (flag > 0){
            logger.debug(Uid + ":修改密码成功");
        }else {
            logger.debug(Uid + ":修改密码失败");
        }
        return flag;
    }

    @Override
    public List<User> showUserInfoService() {
        List<User> lu = ud.showUserInfoDao();
        if (!lu.isEmpty()){
            logger.debug("显示所有用户信息" + lu);
        }
        return lu;
    }

    @Override
    public int registerNewUser(User u) {
        int index = ud.registerNewUser(u);
        if (index > 0){
            logger.debug(u.getUname() + "注册成功");
        }
        return index;
    }
}
