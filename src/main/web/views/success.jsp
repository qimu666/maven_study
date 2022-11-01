<%@ page import="com.dz.entity.NewsUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    NewsUser loginUser = (NewsUser) session.getAttribute("loginUser");
    System.out.println(loginUser);
    if (null == loginUser) {
        response.sendRedirect("login.jsp");
    }
%>
<body>
<%
    if (loginUser != null) {
%>
<%=loginUser.getUserName()%>
<%} else {%>
<a href="login.jsp">点击登录</a>
<%}%>

</body>
</html>
