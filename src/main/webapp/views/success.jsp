<%@ page import="com.dz.entity.NewsUser" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>登陆成功</title>
    <style>
        .a1 {
            width: 600px;
            height: 600px;
            left: 300px;
            top: 200px;
            position: absolute;
        }

        .a2 {
            left: 600px;
            top: 150px;
            font-size: 30px;
            position: absolute;
        }
    </style>
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
        if (sessionMap != null) {
            HttpSession httpSession = sessionMap.get(sessionId);
            loginUser = (NewsUser) httpSession.getAttribute("loginUser");
        }
//        System.out.println(loginUser);
        if (null == loginUser) {
            response.sendRedirect("login.jsp");
        }
    }

%>

<body>

<%
    request.setAttribute("loginUser", loginUser);
%>
<div style="left: 100px;top: 80px;position: absolute">
    <a href="login.jsp">退出登录</a>
</div>
<div class="a1">
    <c:if test="${loginUser!=null}">
        <h1>登陆成功欢迎你： ${loginUser.userName}</h1>
        <br>
        <h1><a href="hello.jsp">娱乐板块</a></h1>
        <h1><a href="pageLimit.jsp">附近好友</a></h1>
    </c:if>
    <c:if test="${loginUser=null}">
        <a href="login.jsp">点击登录</a>
    </c:if>
</div>
<div class="a2">
    <%
        String str = "今天：星期";
        Integer day = 0;
        request.setAttribute("str", str);
        request.setAttribute("day", day);
    %>
    <c:choose>
        <c:when test="${day==0}">
            ${str}1
        </c:when>
        <c:when test="${day==2}">
            ${str}2
        </c:when>
        <c:when test="${day==2}">
            ${str}3
        </c:when>
        <c:when test="${day==3}">
            ${str}4
        </c:when>
        <c:when test="${day==4}">
            ${str}5
        </c:when>
        <c:when test="${day==5}">
            ${str}6
        </c:when>
        <c:when test="${day==6}">
            ${str}7
        </c:when>
        <c:otherwise>
            没有星期8
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
