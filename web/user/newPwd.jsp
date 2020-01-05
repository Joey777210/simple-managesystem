<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 2020/1/3
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <base href=" <%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>

    <%--引入JQuery文件--%>
    <script type="text/javascript" src="js/jquery.js"></script>
    <%--声明代码域--%>
    <script type="text/javascript">
        $(function () {
            $("#fm").submit(function(){
                //校验密码
                if ($("#newPwd").val()==="") {
                    alert("新密码不能为空");
                    return false;
                } else if ($("#cfPwd").val()==="") {
                    alert("确认密码不能为空");
                    return false;
                } else if ($("#newPwd").val() !== $("#cfPwd").val()) {
                    alert("两次密码不一致");
                    return false;
                } else {
                    return true
                }
            })
        })

    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">密码修改</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="user" method="post" id="fm" target="_top">
        <input type="hidden" name="oper" value="cPwd"/>
        <ul class="forminfo">
            <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput"/><i></i></li>
            <li><label>确认密码</label><input name="" id="cfPwd" type="text" class="dfinput"/><i></i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>


</body>

</html>
