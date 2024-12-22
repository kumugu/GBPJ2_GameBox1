<%@page import="com.gamebox.dto.UsersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/header_style.css">
</head>
<body>
<header>
    <div class="navbar">
        <div class="logo">
            <a href="index.jsp">GameBox</a>
        </div>
        <nav>
            <a href="index.jsp">홈</a>
            <a href="games.jsp">상점</a>
            <a href="community.jsp">커뮤니티</a>
            <a href="library.jsp">마이페이지</a>
            <a href="support.jsp">지원</a>
        </nav>
        <div class="user-info">
            <% 
                UsersDTO user = (UsersDTO) session.getAttribute("user");
                if (user != null) { 
            %>
                <img src="<%= user.getProfileImage() %>" alt="Profile" class="profile-image">
                <span><%= user.getUsername() %></span>
                <div class="dropdown-menu">
                    <a href="library.jsp">마이페이지</a>
                    <a href="logout">로그아웃</a>
                </div>
            <% } else { %>
                <a href="login.jsp" class="login-btn">로그인</a>
            <% } %>
        </div>
    </div>
</header>
</body>
</html>