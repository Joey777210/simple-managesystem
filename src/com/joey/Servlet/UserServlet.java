package com.joey.Servlet;

import com.joey.pojo.User;
import com.joey.service.Impl.UserServiceImpl;
import com.joey.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class UserServlet extends HttpServlet {
    Logger logger = Logger.getLogger(UserServlet.class);
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //调用登录
        String oper = req.getParameter("oper");
        if (oper.equals("login")){
            checkUserLogin(req, resp);
        } else if ("out".equals(oper)){
            //退出
            userOut(req, resp);
        }else if ("cPwd".equals(oper)){
            changeUserPwd(req, resp);
        }else if ("show".equals(oper)){
            showUserInfo(req, resp);
        }else if ("reg".equals(oper)){
            registerNewUser(req, resp);
        }else {
            logger.debug("没有对应的操作符" + oper);
        }
    }

    private void registerNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;

        String birth = req.getParameter("birth");
        String[] birthArray = birth.split("/");
        birth = birthArray[2] + "-" + birthArray[0] + "-" + birthArray[1];

        User u = new User(0, uname, pwd, sex, age, birth);
        System.out.println(u);
        int index = us.registerNewUser(u);
        if (index > 0){
            HttpSession hs = req.getSession();
            hs.setAttribute("reg", true);
            resp.sendRedirect("login.jsp");
        }

    }

    private void showUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> lu = us.showUserInfoService();

        if (lu != null){
            req.setAttribute("lu", lu);
            req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
        }
    }

    private void changeUserPwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPwd = req.getParameter("newPwd");
        User u = (User) req.getSession().getAttribute("user");
        int Uid = u.getUid();

        int flag = us.changeUserPwdService(newPwd, Uid);
        if (flag > 0) {
            HttpSession hs = req.getSession();
            hs.setAttribute("cPwd", "true");
            resp.sendRedirect("login.jsp");
            return;
        }
    }

    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession hs = req.getSession();
        //销毁
        hs.invalidate();
        resp.sendRedirect("/MyManager_war_exploded/login.jsp");
    }

    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        User u = us.checkUserLoginService(uname, pwd);
        if (u!=null){
            HttpSession hs = req.getSession();
            //save User u into session
            hs.setAttribute("user", u);
            resp.sendRedirect("/MyManager_war_exploded/main/main.jsp");
            return;
        }else {
            HttpSession hs = req.getSession();
            hs.setAttribute("flag", 0);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
    }
}
