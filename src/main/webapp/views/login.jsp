<%@ page import="com.dz.entity.NewsUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .body1 {
            background-color: aquamarine;
        }

        .h1 {
            color: deeppink;
            width: 200px;
            height: 30px;
        }

        input,
        span {
            width: 166px;
            height: 20px;
            font-size: 15px;
            line-height: 35px;
        }

        .div1 {
            width: 500px;
            height: 500px;
            border: 1px solid coral;
            float: left;
            position: absolute;
            left: 25%;
            top: 19%;
            background-color: cornsilk;
            margin: -50px 0px 0px -50px;
        }

        #mySubmit {
        }

        button {
            height: 31px;
        }

        #mySubmit {
            width: 174px;
            background-color: darksalmon;
        }

        img {
            width: 380px;
            height: 380px;
        }

    </style>
</head>
<body class="body1">
<div class="div1">
    <form action="/login" method="post">
        <h1 class="h1">欢迎登陆</h1>
        <input id="myAccount" type="text" name="name" placeholder="请输入账号"/>
        <span style="color: red"><%=session.getAttribute("errName") != null ? session.getAttribute("errName")  : ""%></span>
        <br>
        <input id="myPassword" type="password" name="password" placeholder="请输入密码"/>
        <span style="color: red"><%=session.getAttribute("errPassword") != null ? session.getAttribute("errPassword") : ""%></span>
        <br>
        <a href="register.jsp">没有账号？点击注册</a>
        <br>
        <button id="mySubmit" type="submit">点击登录</button>
        <span></span>
        <%
            NewsUser loginUser = (NewsUser) session.getAttribute("loginUser");
            if (null == loginUser) {
        %>
        <%
            }
        %>
    </form>
</div>
</body>
</html>
