<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 2020/1/5
  Time: 9:41
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
<!DOCTYPE html>
<html>
<head>
    <base href=" <%=basePath%>">
    <meta charset="UTF-8">
    <title>Basic ValidateBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/MyManager_war_exploded/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/MyManager_war_exploded/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/MyManager_war_exploded/css/demo.css">
    <script type="text/javascript" src="/MyManager_war_exploded/js/jquery.min.js"></script>
    <script type="text/javascript" src="/MyManager_war_exploded/js/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic ValidateBox</h2>
<p>It's easy to add validate logic to a input box.</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="Register" style="width:400px;padding:10px 60px 20px 60px">
    <form action="user" method="post">
        <input type="hidden" name="oper" value="reg">
    <table cellpadding="5">
        <tr>
            <td>用户名:</td>
            <td><input class="easyui-validatebox textbox" name="uname" data-options="required:true"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input class="easyui-validatebox textbox" name="pwd" data-options="required:true"></td>
        </tr>
        <td>性别:</td>
        <td>
            男：<input type="radio" name="sex" value="1">
            女：<input type="radio" name="sex" value="0">
        </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input class="textbox" name="age" value=""></td>
        </tr>
        <tr>
            <td>出生日期:</td>
            <td><input class="easyui-datebox textbox" name="birth"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册">
            </td>
        </tr>

    </table>
    </form>
</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>

</body>
</html>