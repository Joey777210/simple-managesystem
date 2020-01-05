package com.joey.dao.Impl;

import com.joey.dao.UserDao;
import com.joey.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User u = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "zhq1099109788");
            String sql = "select * from user where uname=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("Uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                u.setSex(rs.getString("sex"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }

    @Override
    public int changeUserPwdDao(String newPwd, int Uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        //标识是否修改成功
        int flag = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exercise?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "zhq1099109788");


            String sql = "update user set pwd=? where Uid=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, newPwd);
            ps.setInt(2, Uid);

            flag = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return flag;
    }

    @Override
    public List<User> showUserInfoDao() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> lu = null;
        User u = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "zhq1099109788");
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lu = new ArrayList<>();
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("Uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                u.setSex(rs.getString("sex"));
                lu.add(u);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lu;
    }

    @Override
    public int registerNewUser(User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "zhq1099109788");

            String sql = "insert into user VALUES(default,?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUname());
            ps.setString(2, u.getPwd());
            ps.setString(3, u.getSex());
            ps.setString(4, u.getBirth());
            ps.setInt(5, u.getAge());
            index = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }
}
