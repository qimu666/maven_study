<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <style>
        .index {
            width: 600px;
            height: 800px;
            border: 1px solid coral;
            /*left: 300px;*/
            /*position: marker;*/
            margin: 50px;
        }
        .index-login{
            left: 300px;
            top: 300px;
            position: absolute;
        }
        .index-register{
            left: 300px;
            top: 350px;
            position: absolute;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="index-login"><a href="views/login.jsp">登录</a></div>
    <div class="index-register"><a href="views/register.jsp">注册账号</a></div>
</div>
</body>
</html>