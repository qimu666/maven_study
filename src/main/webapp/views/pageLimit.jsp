<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../statics/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<table id="userLists" style="border: khaki 1px solid;">
    <thead>
    <td>id</td>
    <td>账号</td>
    <td>密码</td>
    <td>邮箱</td>
    <td>类型</td>
    </thead>
    <tbody id="userList"></tbody>
</table>
<nav>
    <button>首页</button>
    <button>上一页</button>
    <button>2</button>
    <button>3</button>
    <button>4</button>
    <button>末页</button>
</nav>
</body>
</html>
<script>
    $(function () {
        getUserList()

        function getUserList() {
            $.post(
                "/pageLimits",
                {page: 1, views: 3},
                function (result) {
                    console.log(result)
                    for (let i = 0; i < result.length; i++) {
                        $("#userList").append(
                            "<tr style='border: red 1px solid'>" +
                            "<td>" + result[i].id + "</td>" +
                            "<td>" + result[i].userName + "</td>" +
                            "<td>" + result[i].password + "</td>" +
                            "<td>" + result[i].email + "</td>" +
                            "<td>" + result[i].userType + "</td>" +
                            "</tr>"
                        )
                    }
                }, "json"
            )
        }
    })
</script>
