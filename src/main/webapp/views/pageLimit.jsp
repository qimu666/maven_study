<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>附近好友</title>
    <script type="text/javascript" src="../statics/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<table id="userLists" style="border:1px salmon solid ;border-collapse: collapse;width:55% ;height: 20%">
    <thead>
    <tr style="text-align: center">
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>userType</td>
    </tr>
    </thead>
    <tbody id="userList" style="text-align: center;height: 100px">

    </tbody>
</table>
<nav id="butGroup">
    <%--    <button onclick="chagePage(false)">上一页</button>--%>
    <%--    <button onclick="chagePage(true)">下一页</button>--%>
</nav>
</body>
</html>
<script>
    var pageNum = 1;
    var viewsNum = 3;
    var allCount = 0;
    $(function () {
        getUserList(pageNum, viewsNum)
    })

    function chagePage(isNext, toPage) {
        if (isNext != undefined) {
            if (isNext) {
                pageNum = pageNum * viewsNum >= allCount ? pageNum : pageNum + 1;
            } else {
                pageNum = pageNum == 1 ? 1 : pageNum - 1;
            }
        }
        if (toPage != undefined) {
            pageNum = toPage
        }
        getUserList(pageNum, viewsNum)
    }

    function getUserList(page, views) {
        $.post(
            "/A/pageLimits",
            {page: page, views: views},
            function (result) {
                allCount = result.allCount;
                $("#userList").html(" ")
                $("#butGroup").html(" ")
                let totalPage = (allCount / views).toFixed(0)
                console.log(totalPage)
                if (allCount % views != 0) {
                    totalPage++;
                }
                if (pageNum != 1) {
                    $("#butGroup").append("<button onclick='chagePage(false)'>上一页</button>")
                }
                for (let i = 1; i < totalPage; i++) {
                    $("#butGroup").append("<button onclick='chagePage(undefined," + i + ")'>" + i + "</button>")
                }
                if (pageNum != totalPage) {
                    $("#butGroup").append("<button onclick='chagePage(true)'>下一页</button>")
                }
                let data = result.data;
                console.log(data)
                for (let i = 0; i < data.length; i++) {
                    $("#userList").append(
                        "<tr style='border:1px solid pink;background-color:cyan ''>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].userName + "</td>" +
                        "<td>" + data[i].password + "</td>" +
                        "<td>" + data[i].email + "</td>" +
                        "<td>" + data[i].userType + "</td>" +
                        "</tr>"
                    )
                }
            }, "json"
        )
    }
</script>
