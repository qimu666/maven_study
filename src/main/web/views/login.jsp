<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .body1{
            background-color: aquamarine;
        }

        #styCode {
            position: absolute;
            color: aqua;
            background-color: pink;
            width: 80px;
            height: 30px;
            font-size: 23px;
            top: 50.6%;
            text-align: center;
            font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
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

        .div2 {
            width: 500px;
            height: 300px;
            float: left;
            position: absolute;
            left: 46%;
            top: 38%;
            margin: -50px 0px 0px -50px;
        }

        .div3 {
            float: left;
            position: absolute;
            left: 63%;
            top: 68.2%;
            margin: -50px 4px 0px -50px;
        }

        .div4 {
            float: left;
            position: absolute;
            left: 46%;
            top: 83.5%;
            margin: -50px 4px 0px -50px;
        }

        .div5 {
            float: left;
            position: absolute;
            left: 10%;
            top: 80.5%;
            margin: -50px 4px 0px -50px;

        }

        #butcode {
            background-color: aquamarine;
        }

        #mySubmit {}

        button {
            height: 31px;
        }

        #mySubmit {
            width: 174px;
            background-color: darksalmon;
        }

        .b {
            position: relative;
            color: chocolate;
            width: 160px;
            height: 60px;
            top: 60px;
            left: 300px;
            font-size: 40px;
            line-height: 40px;
        }

        .a {
            width: 400px;
            height: 400px;
            top: 60px;
            left: 180px;
            border: 1px solid #0a3b98;
            position: relative;
            color: peru;
            font-size: 20px;
            line-height: 40px;
        }

        img {
            width: 380px;
            height: 380px;
        }

    </style>
</head>
<body class="body1">
<div class="div1">
    <form action="/test" method="get">
            <h1 class="h1">欢迎登陆</h1>
            <input id="myAccount" type="text" name="name" placeholder="请输入账号"/>
            <input id="myPassword" type="password" name="password" placeholder="请输入密码"/>
            <button id="mySubmit" type="submit" >点击登录</button>
    </form>
</div>
</body>
</html>
