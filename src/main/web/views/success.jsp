<%@ page import="com.dz.entity.NewsUser" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登陆成功</title>
</head>
<%
    NewsUser loginUser = (NewsUser) session.getAttribute("loginUser");
    Cookie[] cookies = request.getCookies();
    String sessionId = "";
    for (int i = 0; i < cookies.length; i++) {
        Cookie cookie = cookies[i];
        if (cookie.getName().equals("session_id")) {
            sessionId = cookie.getValue();
        }
    }
    if (!sessionId.trim().equals("")) {
        Map<String, HttpSession> sessionMap =
                (Map<String, HttpSession>) application.getAttribute("sessionMap");
        HttpSession httpSession = sessionMap.get(sessionId);
        loginUser = (NewsUser) httpSession.getAttribute("loginUser");
        System.out.println(loginUser);
        if (null == loginUser) {
            response.sendRedirect("login.jsp");
        }
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
