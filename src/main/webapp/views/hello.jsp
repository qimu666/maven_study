<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    if (session.getAttribute("kudos") == null) {
        session.setAttribute("kudos", 0);
        Integer kudos = (Integer) session.getAttribute("kudos");
        session.setAttribute("kudos", kudos);
    }
%>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../statics/js/jquery-3.6.1.js"></script>
</head>
<body>
<div style="width:800px;height:800px;left:300px;border: 1px solid coral;position: absolute;">
    <div style="width:160px;height:30px;top: 40px;left: 30px ;position: inherit">
        <a href="success.jsp">返回主页面</a>
    </div>
    <div style="width:160px;height:30px;top: 400px;left: 350px;position: absolute;">
        <input type="text">
        <button id="kudos">累计点赞<span><%=session.getAttribute("kudos")%></span>
        </button>
    </div>
</div>
</body>

</html>
<script>
    $(function () {
            $("#kudos").on("click", function () {
                syan();
            })

            function syan() {
                $.ajax("<%=request.getContextPath()%>/login", {
                    type: "GET",
                    dataType: "text",
                    data: {
                        "kudos": <%=session.getAttribute("kudos")%>
                    },
                    success: function (result) {
                        $("#kudos span").text(<%=session.getAttribute("kudos")%>)
                        $("#kudos span").load(location.href+"#kudos span")
                    }
                })
            }
        }
    )
</script>