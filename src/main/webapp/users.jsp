<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.gamebox.dao.UsersDAO, com.gamebox.dto.UsersDTO" %>
<%
    // DAO를 통해 사용자 목록 가져오기
    UsersDAO usersDAO = new UsersDAO();
    List<UsersDTO> usersList = usersDAO.getAllUsers(); // getAllUsers() 메서드는 모든 사용자 정보를 가져오는 메서드
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사용자 관리</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        form {
            margin-bottom: 20px;
        }
        .btn {zzzzzz
            padding: 5px 10px;
            border: none;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-delete:hover {
            background-color: #a71d2a;
        }
    </style>
</head>
<body>
    <h1>사용자 관리</h1>

    <!-- 사용자 추가 폼 -->
    <form action="users" method="post">
        <input type="hidden" name="action" value="create">
        <h2>새 사용자 추가</h2>
        <label>사용자 이름: <input type="text" name="username" required></label><br>
        <label>비밀번호: <input type="password" name="password" required></label><br>
        <label>이메일: <input type="email" name="email" required></label><br>
        <label>프로필 이미지: <input type="text" name="profileImage"></label><br>
        <button type="submit" class="btn">사용자 추가</button>
    </form>

    <!-- 사용자 목록 표시 -->
    <h2>사용자 목록</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>사용자 이름</th>
                <th>이메일</th>
                <th>프로필 이미지</th>
                <th>등록일</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <% for (UsersDTO user : usersList) { %>
                <tr>
                    <td><%= user.getUserId() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getProfileImage() == null ? "N/A" : user.getProfileImage() %></td>
                    <td><%= user.getCreatedAt() %></td>
                    <td>
                        <!-- 수정 폼 -->
                        <form action="users" method="post" style="display: inline-block;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                            <input type="text" name="username" value="<%= user.getUsername() %>" required>
                            <input type="email" name="email" value="<%= user.getEmail() %>" required>
                            <input type="password" name="password" placeholder="새 비밀번호">
                            <input type="text" name="profileImage" value="<%= user.getProfileImage() == null ? "" : user.getProfileImage() %>">
                            <button type="submit" class="btn">수정</button>
                        </form>
                    </td>
                    <td>
                        <!-- 삭제 버튼 -->
                        <form action="users" method="post" style="display: inline-block;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                            <button type="submit" class="btn btn-delete">삭제</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
