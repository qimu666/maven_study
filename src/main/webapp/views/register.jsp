<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号注册</title>
    <script type="text/javascript" src="../statics/js/jquery-3.6.1.js"></script>
</head>
<body>
<form action="/A/register" method="post">
    <input id="myAccount" type="text" name="username" placeholder="请输入账号"/>
    <br>
    <input id="myPassword01" type="password" name="password1" placeholder="请输入密码"/>
    <br>
    <input id="myPassword02" type="password" name="password2" placeholder="请确认您的密码"/>
    <br>
    <input id="email" type="text" name="email" placeholder="请输入邮箱"/>
    <button id="mySubmit" type="submit">点击注册</button>
    <span  id="emr" name="reg"
          style="color: red"><%=session.getAttribute("register") == null ? "" : session.getAttribute("register")%></span>
</form>
</body>
<script>
    $(function () {
        $("#myAccount").on("change", function () {
            $.ajax("/register", {
                type: "GET",
                data: {
                    "username": $("#myAccount").val()
                },
                success: function (result) {
                    let str = "";
                    str = result;
                    if (str.indexOf("不可用") != -1) {
                        $("#emr").text(result)
                    }else {
                        $("#emr").text(result)
                    }
                },
            })
        })
    })
</script>
</html>
