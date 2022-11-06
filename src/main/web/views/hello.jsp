<%--
  Created by IntelliJ IDEA.
  User: qimu
  Date: 2022/11/3
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("kudos") == null) {
        session.setAttribute("kudos", 0);
    }
%>
<div style="width:800px;height:800px;left:300px;border: 1px solid coral;position: absolute;">
    <div style="width:160px;height:30px;top: 40px;left: 30px ;position: inherit">
        <a href="success.jsp">返回主页面</a>
    </div>
    <div style="width:80px;height:30px;top: 400px;left: 400px;position: absolute;">
        <button><a href="/login">点赞数</a><%=session.getAttribute("kudos")%>
        </button>
    </div>
</div>
</body>
</html>
