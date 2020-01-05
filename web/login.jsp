<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.joey.Servlet.UserServlet" %><%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 2020/1/2
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href=" <%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>
s
<div class="loginbody">

    <span class="systemlogo"></span>
    <%
        //登录错误提示
        Object obj = session.getAttribute("flag");
        if (obj!=null){
    %>
    <div style="text-align: center;">
        <span style="font-size: 20px;color: white;font-weight: bold">用户名或密码错误</span>
    </div>
    <%
        }
    %>
<%--___________________________________________________________________________________--%>
    <%
        //密码修改提示
        Object cPwdFlag = session.getAttribute("cPwd");
        if (cPwdFlag!=null){
    %>
    <div style="text-align: center;">
        <span style="font-size: 20px;color: white;font-weight: bold">修改密码成功</span>
    </div>
    <%
        }
        session.removeAttribute("cPwd");
    %>
<%--————————————————————————————————————————————————————————————————————————————————————————————--%>
    <%
        //注册提示
        Object regFlag = session.getAttribute("reg");
        if (regFlag!=null){
    %>
    <div style="text-align: center;">
        <span style="font-size: 20px;color: white;font-weight: bold">注册成功</span>
    </div>
    <%
        }
        session.removeAttribute("reg");
    %>

    <div class="loginbox">
        <form action="user" method="post">
                <input type="hidden" name="oper" value="login"/>
            <ul>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser"/></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd"/></li>
                <li><input name="" type="submit" class="loginbtn" value="登录"
                           onclick="javascript:window.location='main.html'"/><label><a href="user/newUser.jsp"/>注册</label><label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>
    </div>

</div>


<div class="loginbm">版权所有 2014 <a href="http://www.uimaker.com">Joey</a> 仅供学习交流，勿用于任何商业用途</div>


</body>

</html>