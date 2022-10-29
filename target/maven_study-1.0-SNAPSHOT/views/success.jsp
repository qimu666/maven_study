<%@ page import="com.dz.entity.NewsUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    NewsUser loginUser = (NewsUser) session.getAttribute("loginUser");
    System.out.println(loginUser);
%>
<%=loginUser.getUserName()+loginUser.getPassword()%>
<h1>登录成功</h1>
</body>
</html>
